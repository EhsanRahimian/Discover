package com.nicootech.discover.model;

import java.util.List;

public class FeedResponse {
    private int numResults;
    private int nextOffset;
    private List<Restaurant> stores;

    public int getNumResults() {
        return numResults;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public List<Restaurant> getStores() {
        return stores;
    }
}
