package com.nicootech.discover.viewmodel;

import com.nicootech.discover.model.Restaurant;
import com.nicootech.discover.repositories.RestaurantRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

public class RestaurantListViewModel extends ViewModel {
    public LiveData<PagedList<Restaurant>> getRestaurantList() {
        return RestaurantRepository.getInstance().getRestaurantList();
    }
}
