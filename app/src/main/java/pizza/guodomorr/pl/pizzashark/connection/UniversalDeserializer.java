package pizza.guodomorr.pl.pizzashark.connection;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import pizza.guodomorr.pl.pizzashark.model.location.Delicious;
import pizza.guodomorr.pl.pizzashark.model.location.RegionDistrict;
import pizza.guodomorr.pl.pizzashark.model.restaurants.Restaurant;


/**
 * Created by lukasz on 10.10.15.
 * Deserializer for all used jsons
 */
public class UniversalDeserializer  {
    public static final String TAG = UniversalDeserializer.class.getSimpleName();

    public static Delicious getDelicious(@NonNull String json) {
        Log.d(TAG, "getDelicious " + json);
        return new Gson().fromJson(json.trim(), Delicious.class);
    }

//    @SuppressWarnings("unchecked cast of template type")
//    public T get(String s) {
//        return new Gson().fromJson(s,new TypeToken<T>() {
//        }.getType());
//    }

    public static List<Restaurant> getRestaurants(@NonNull String json) {
        Log.d(TAG, "getRestaurants " + json);
        return new Gson().fromJson(json, new TypeToken<List<Restaurant>>() {
        }.getType());
    }

    public static String getRegionDistrict(Delicious delicious) {
        String x = "";
//        for (OtherRegion region : delicious.getOtherRegion())
//            x += region.getName() + '\n';
        x += "REGION DISTRICTS\n";
        for (RegionDistrict region : delicious.getRegionDistrict())
            x += region.getFullName() + '\n';
        x += "REGION PLACES\n";
        for (RegionDistrict region : delicious.getRegionPlz())
            x += region.getName() + '\n';

        return x;
    }
}
