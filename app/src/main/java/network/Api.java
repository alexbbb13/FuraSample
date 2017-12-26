package network;

/**
 * Created by alex on 25.12.17.
 */

import network.response.PlacesResponse;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface Api
{
    @GET(GET_POINTS)
    Observable<PlacesResponse> getAllPoints(@Query("startFrom") int startFrom);

    static final String GET_POINTS = "api/test/places";
}