package com.nicootech.discover.repositories;

import com.nicootech.discover.model.RestaurantResponse;
import com.nicootech.discover.model.RestaurantV2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestaurantWebService {


    @GET("/v1/store_feed")
    Call<RestaurantResponse> getRestaurants(
            @Query("lat") double lat,
            @Query("lng") double lng,
            @Query("offset") int offset,
            @Query("limit") int limit
    );
    @GET("/v2/restaurant/{id}/")
    Call<RestaurantV2> getRestaurantDetail(@Path("id") int id);
}
