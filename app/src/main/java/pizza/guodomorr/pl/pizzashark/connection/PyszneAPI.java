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

    //    https://pyszne.pl/restauracja-krakow-31-416#!
    // &Rating=%5B0.8,4%5D&Ratingcount=%5B299,2047%5D&Mincart=%5B15,110%5D&Deliverycost=%5B3.5,18.7%5D
    @GET("/restauracja-krakow-{zipCode}#!&Rating=%5B{ratingMin}," +
            "{ratingMax}%5D&Ratingcount=%5B{ratingCountMin},{ratingCountMax}" +
            "%5D&Mincart=%5B{minCart},{maxCart}" +
            "%5D&Deliverycost=%5B{minDeliveryCost},{maxDeliveryCost}" +
            "&discountNewCustomer={discountNewCustomer2}" +
            "&discountNormal={discountNormal2}" +
            "&allStamps={allStamps2}")

//    &discountNewCustomer=true&discountNormal=true&allStamps=true
    rx.Observable<Response> getNearbyRestaurantsWithFilter(@Path("zipCode") String zipCode,
                                                           @Path("ratingMin") Double ratingMin,
                                                           @Path("ratingMax") Double ratingMax,
                                                           @Path("ratingCountMin") Integer ratingCountMin,
                                                           @Path("ratingCountMax") Integer ratingCountMax,
                                                           @Path("minCart") Double minCart,
                                                           @Path("maxCart") Double maxCart,
                                                           @Path("minDeliveryCost") Double minDeliveryCost,
                                                           @Path("maxDeliveryCost") Double maxDeliveryCost,
                                                           @Path("discountNewCustomer2") Boolean discountNewCustomer,
                                                           @Path("discountNormal2") Boolean discountNormal,
                                                           @Path("allStamps2") Boolean allStmaps);

    @GET("/restauracja-krakow-{zipCode}#!" +
            "&Rating=[{ratingMin},{ratingMax}]" +
            "&Ratingcount=[{ratingCountMin},{ratingCountMax}]" +
            "&Mincart=[{minCart},{maxCart}]" +
            "&Deliverycost=[{minDeliveryCost},{maxDeliveryCost}]" +
            "&discountNewCustomer={discountNewCustomer2}" +
            "&discountNormal={discountNormal2}" +
            "&allStamps={allStamps2}")
    rx.Observable<Response> getNearbyRestaurantsWithFilter2(@Path("zipCode") String zipCode,
                                                            @Path("ratingMin") Double ratingMin,
                                                            @Path("ratingMax") Double ratingMax,
                                                            @Path("ratingCountMin") Integer ratingCountMin,
                                                            @Path("ratingCountMax") Integer ratingCountMax,
                                                            @Path("minCart") Double minCart,
                                                            @Path("maxCart") Double maxCart,
                                                            @Path("minDeliveryCost") Double minDeliveryCost,
                                                            @Path("maxDeliveryCost") Double maxDeliveryCost,
                                                            @Path("discountNewCustomer2") Boolean discountNewCustomer,
                                                            @Path("discountNormal2") Boolean discountNormal,
                                                            @Path("allStamps2") Boolean allStmaps);


}
