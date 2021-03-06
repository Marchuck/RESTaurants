package pizza.guodomorr.pl.pizzashark;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import pizza.guodomorr.pl.pizzashark.connection.GetContent;
import pizza.guodomorr.pl.pizzashark.connection.PyszneAPI;
import pizza.guodomorr.pl.pizzashark.model.location.Delicious;
import pizza.guodomorr.pl.pizzashark.model.restaurants.Restaurant;
import pizza.guodomorr.pl.pizzashark.ui.RestaurantAdapter;
import rx.functions.Action0;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private int currentTextSize = 15;
    private RestaurantAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        final TextView tView = (TextView) findViewById(R.id.textView);
//        tView.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
        final RecyclerView parent2 = (RecyclerView) findViewById(R.id.parent2);
        adapter = new RestaurantAdapter(new ArrayList<Restaurant>(), new RestaurantAdapter.OnClickCallback() {
            @Override
            public void onClick(int position, Restaurant restaurant) {
                Log.d(TAG, "onClick [" + position + "]");
                Log.d(TAG, "restaurant: " + restaurant);
            }
        });
        parent2.setLayoutManager(new LinearLayoutManager(this));
        parent2.setAdapter(adapter);

        final RelativeLayout parent = (RelativeLayout) findViewById(R.id.parent);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        final FABToolbarLayout toolbarParent = (FABToolbarLayout) findViewById(R.id.fabtoolbar);
        final FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.fabtoolbar_fab);
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff6343")));
        btn.setRippleColor(Color.parseColor("#ff6343"));
        final LinearLayout lay = (LinearLayout) toolbarParent.findViewById(R.id.fabtoolbar_toolbar);
        lay.setBackground(new ColorDrawable(Color.parseColor("#ff6343")));
        final ImageView filter = (ImageView) lay.findViewById(R.id.filter);
        final ImageView exit = (ImageView) lay.findViewById(R.id.exit);

        parent2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        toolbarParent.hide();
                }
                return false;
            }
        });
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick " + currentTextSize);
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent, 200);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick " + currentTextSize);
                onBackPressed();
            }
        });

        final GetContent getContent = new GetContent();
        getContent.create(getReceiver(getContent));
        getContent.start(this);

    }

    private GetContent.Receiver getReceiver(final GetContent getContent) {
        return new GetContent.Receiver() {
            @Override
            public Action0 showLoader(boolean show) {
                return MainActivity.this.showLoader(show, getContent.getStartMillis(), progressBar);
            }

            @Override
            public void onReceiveRestaurants(List<Restaurant> restaurants) {
                Log.d(TAG, "onReceiveRestaurants ");
                for (Restaurant rest : restaurants) {
                    Log.d(TAG, "next: " + rest.getName() + "," + rest.getRestaurantCategory());
                }
                adapter.updateData(restaurants);
            }

            @Override
            public void onReceiveDelicious(Delicious delicious) {
                Log.d(TAG, "onReceiveDelicious ");
                Log.d(TAG, "next: " + delicious.getName() + ", " + delicious.getLocationName() + "," + delicious.getPlz());
            }
        };
    }

    private Action0 showLoader(final boolean show, final long millis, final ProgressBar progressBar) {
        return new Action0() {
            @Override
            public void call() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "Show loader, current thread: " + Thread.currentThread().getName());
                        Log.d(TAG, "Show loader on UI, current thread: " + Thread.currentThread().getName());
                        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
                        if (!show) {
                            Log.d(TAG, "time elapsed: " + (System.currentTimeMillis() - millis) + " ms");
                        }
                    }
                });
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 200: {
                Log.d(TAG, "onActivityResult " + requestCode + "," + resultCode + "," + (data == null));
                if (data != null) {
                    Double minRating = data.getDoubleExtra(Constants.MIN_RATING, 0);
                    Double maxRating = data.getDoubleExtra(Constants.MAX_RATING, 5.0);

                    Integer minRatingCount = data.getIntExtra(Constants.MIN_RATING_COUNT, 0);
                    Integer maxRatingCount = data.getIntExtra(Constants.MAX_RATING_COUNT, 2350);

                    Double minCart = data.getDoubleExtra(Constants.MIN_CART, 0.0);
                    Double maxCart = data.getDoubleExtra(Constants.MAX_CART, 120.0);

                    Double minDeliveryCost = data.getDoubleExtra(Constants.MIN_DELIVERY, 0.0);
                    Double maxDeliveryCost = data.getDoubleExtra(Constants.MAX_DELIVERY, 20.0);

                    Boolean newCustomerDiscount = data.getBooleanExtra(Constants.NEW_CUSTOMER, false);
                    Boolean normalDiscount = data.getBooleanExtra(Constants.NORMAL, false);
                    Boolean allStamps = data.getBooleanExtra(Constants.ALL_STAMPS, false);


                    adapter.updateData(new ArrayList<Restaurant>());
                    GetContent contentGetter = new GetContent();

                    contentGetter.createAdvanced(getReceiver(contentGetter), PyszneAPI.ZIP_CODE_TEST,
                            minRating, maxRating, minRatingCount, maxRatingCount, minCart, maxCart, minDeliveryCost, maxDeliveryCost,
                            newCustomerDiscount, normalDiscount, allStamps);
                    contentGetter.start(MainActivity.this);
                }

                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed ");
        super.onBackPressed();
        Log.d(TAG, "exit from app");
    }
}
