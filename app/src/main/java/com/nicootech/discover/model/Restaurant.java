package com.nicootech.discover.model;

import java.util.List;

public class Restaurant {

    private class Status {
        private List<Integer> asapMinutesRange;
    }

    private int id;
    private String name;
    private String description;
    private String coverImgUrl;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }



    public boolean equals(Object another) {
        if (this == another) return true;

        if (!(another instanceof Restaurant)) {
            return false;
        }

        Restaurant anotherRestaurant = (Restaurant)another;
        return anotherRestaurant.id == id &&
                anotherRestaurant.name.equals(name) &&
                anotherRestaurant.description.equals(description) &&
                anotherRestaurant.coverImgUrl.equals(coverImgUrl);

    }
}
