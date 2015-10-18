package pizza.guodomorr.pl.pizzashark.connection;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by lukasz on 10.10.15.
 * Api for requests
 */
public interface PyszneAPI {

    String ENDPOINT = "https://pyszne.pl";
    String ZIP_CODE_TEST = "31-416";

    @GET("/restauracja-krakow-{zipCode}#!")
    rx.Observable<Response> getNearbyRestaurants(@Path("zipCode") String zipCode);
}
