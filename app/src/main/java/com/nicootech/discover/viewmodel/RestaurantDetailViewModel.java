package com.nicootech.discover.viewmodel;

import com.nicootech.discover.model.RestaurantV2;
import com.nicootech.discover.repositories.RestaurantRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class RestaurantDetailViewModel extends ViewModel {
    public LiveData<RestaurantV2> getRestaurantDetail(int id) {
        return RestaurantRepository.getInstance().getRestaurantDetail(id);
    }
}

