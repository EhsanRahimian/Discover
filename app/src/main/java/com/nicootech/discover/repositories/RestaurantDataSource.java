package com.nicootech.discover.repositories;

import android.util.Log;

import com.nicootech.discover.model.RestaurantResponse;
import com.nicootech.discover.model.Restaurant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;
import retrofit2.Response;

import static com.nicootech.discover.util.Constants.LAT;
import static com.nicootech.discover.util.Constants.LNG;

public class RestaurantDataSource extends PositionalDataSource<Restaurant> {
    private static final String TAG = RestaurantRepository.class.getSimpleName();


    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Restaurant> callback) {
        try {
            Response<RestaurantResponse> response = RestaurantRepository.getInstance().getRestaurantWebService()
                    .getRestaurants(LAT, LNG, params.requestedStartPosition, params.requestedLoadSize).execute();
            if (response.isSuccessful()) {
                // TODO: this line of log should not go to production build (same as other similar places)
                Log.d(TAG, "Retrofit call to get restaurant list success with response: " + response.body());
                List<Restaurant> restaurantList = new ArrayList<>();
                if (response.body() != null) {
                    restaurantList = response.body().getStores();
                    if (restaurantList == null) {
                        restaurantList = new ArrayList<>();
                    }
                }
                callback.onResult(restaurantList, response.body().getNext_offset());
            } else {
                Log.e(TAG, "Retrofit call to get restaurant list failed with response: " + response.body());
            }
        } catch (IOException e) {
            Log.e(TAG, "Retrofit call to get restaurant list got IO Exception: " + e.toString());
        }
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Restaurant> callback) {
        try {
            Response<RestaurantResponse> response = RestaurantRepository.getInstance().getRestaurantWebService().
                    getRestaurants(LAT, LNG, params.startPosition, params.loadSize).execute();
            if (response.isSuccessful()) {
                Log.d(TAG, "Retrofit call to get restaurant list success with response: " + response.body());
                List<Restaurant> restaurantList = new ArrayList<>();
                if (response.body() != null) {
                    restaurantList = response.body().getStores();
                    if (restaurantList == null) {
                        restaurantList = new ArrayList<>();
                    }
                }
                callback.onResult(restaurantList);
            } else {
                Log.e(TAG, "Retrofit call to get restaurant list failed with response: " + response.body());
            }
        } catch (IOException e) {
            Log.e(TAG, "Retrofit call to get restaurant list got IO Exception: " + e.toString());
        }
    }
}

