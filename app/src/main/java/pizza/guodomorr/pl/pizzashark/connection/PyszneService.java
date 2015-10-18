package pizza.guodomorr.pl.pizzashark.connection;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Lukasz Marczak on 2015-08-26.
 */
public interface PyszneService {

    String PYSZNE_ENDPOINT = "https://pyszne.pl";

    //https://pyszne.pl/restauracja-krakow-31-416#!&Mincart=[12,66]
    // &Rating=[0.8,3.8]&Deliverycost=[2,14.3]&Ratingcount=[0,1959]
    @GET("/restauracja-{city}-{kod_pocztowy}#!")
    rx.Observable<Response> getResultsRestaurants(@Path("city") String city,
                                                  @Path("kod_pocztowy") String zip_code,
                                                  @Query("Mincart") String przedzial_zamowienia,
                                                  @Query("Rating") String rating,
                                                  @Query("Deliverycost") String deliveryCost,
                                                  @Query("RatingCount") String ratingCount);

}
