package pizza.guodomorr.pl.pizzashark.connection;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import pizza.guodomorr.pl.pizzashark.model.location.Delicious;
import pizza.guodomorr.pl.pizzashark.model.restaurants.Restaurant;
import retrofit.RestAdapter;
import retrofit.client.Response;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author lukasz
 * @since 10.10.15.
 * receives json number 13
 */
public class GetContent {
    private Activity context;
    private long startMillis;

    public long getStartMillis() {
        return startMillis;
    }

    private Observable<Response> queryObservable;

    public static final String TAG = GetContent.class.getSimpleName();

    public interface Receiver {
        Action0 showLoader(boolean show);

        void onReceiveRestaurants(List<Restaurant> restaurants);

        void onReceiveDelicious(Delicious delicious);
    }

    private Receiver receiver;

    private PyszneAPI getApi() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(PyszneAPI.ENDPOINT).build();
        return adapter.create(PyszneAPI.class);
    }

    public void create(Receiver receiver) {
        this.receiver = receiver;
        queryObservable = getApi().getNearbyRestaurants(PyszneAPI.ZIP_CODE_TEST);
    }

    public void createAdvanced(Receiver receiver, String zipCode,
                               Double minRating, Double maxRating,
                               Integer minRatingCount, Integer maxRatingCount,
                               Double minCart,
                               Double maxCart,
                               Double minDeliveryCost,
                               Double maxDeliveryCost,
                               Boolean discountNewCustomer,
                               Boolean discountNormal,
                               Boolean allStmaps) {
        this.receiver = receiver;
        queryObservable = getApi().getNearbyRestaurantsWithFilter2(
                zipCode, minRating, maxRating, minRatingCount,
                maxRatingCount, minCart, maxCart,
                minDeliveryCost, maxDeliveryCost,
                discountNewCustomer, discountNormal, allStmaps);

    }

    public void start(final Activity context) {
        Log.d(TAG, "onCreate ");
        startMillis = System.currentTimeMillis();
        queryObservable
                .subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread())
                .doOnSubscribe(receiver.showLoader(true)).doOnCompleted(receiver.showLoader(false))
                .subscribe(new Action1<Response>() {
                    @Override
                    public void call(Response response) {
                        Log.d(TAG, "for url  = " + response.getUrl() + ", reason is " + response.getReason());
                        Log.d(TAG, "current thread: " + Thread.currentThread().getName());
                        InputStream inputStream = null;
                        String string = "";
                        try {
                            inputStream = response.getBody().in();
                            java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
                            string = s.hasNext() ? s.next() : "";
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (inputStream != null)
                                tryCloseStream(inputStream);
                        }

                        final String[] messages = string.split("Yd.predefined");
                        if (messages.length > 12) {

                            messages[12] = messages[12].replace("[\"location\"] = ", "").replace(";", "");
                        }
                        if (messages.length > 14) {

                            messages[14] = messages[14].replace("[\"restaurants\"] = ", "").replace(";", "");
                        }
                        for (int j = 0; j < messages.length; j++)
                            Log.d(TAG, "messages[" + j + "] = " + messages[j]);
                        context.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                receiver.onReceiveDelicious(UniversalDeserializer.getDelicious(messages[12]));
                                receiver.onReceiveRestaurants(UniversalDeserializer.getRestaurants(messages[14]));
                            }
                        });

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, "onError");
                        Log.e(TAG, "caused by " + throwable.getCause());
                        Log.e(TAG, "message " + throwable.getMessage());
                        throwable.printStackTrace();
                    }
                });
    }

    private void tryCloseStream(@Nullable InputStream in) {
        Log.d(TAG, "tryCloseStream ");
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                Log.e(TAG, "failed to close stream");
                e.printStackTrace();
            }
        }
    }
}
