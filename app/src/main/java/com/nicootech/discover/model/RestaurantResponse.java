package com.nicootech.discover.model;

import java.util.List;

public class RestaurantResponse {
//    private int num_result;

    private int next_offset;

    private List<Restaurant> stores;

//    public int getNum_results() {
//        return num_result;
//    }

    public int getNext_offset() {
        return next_offset;
    }

    public List<Restaurant> getStores() {
        return stores;
    }
}
