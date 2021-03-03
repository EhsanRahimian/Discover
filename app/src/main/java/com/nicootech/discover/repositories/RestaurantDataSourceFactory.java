package com.nicootech.discover.repositories;

import com.nicootech.discover.model.Restaurant;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

class RestaurantDataSourceFactory extends DataSource.Factory<Integer, Restaurant> {
    @NonNull
    @Override
    public DataSource<Integer, Restaurant> create() {
        return new RestaurantDataSource();
    }
}
