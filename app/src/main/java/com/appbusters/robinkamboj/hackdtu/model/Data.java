package com.appbusters.robinkamboj.hackdtu.model;

/**
 * Created by robinkamboj on 11/02/17.
 */

public class Data {

    public String name;
    public String starting_point;
    public String destination_point;
    public String distance;

    public Data(String name, String starting_point, String destination_point, String distance) {
        this.name = name;
        this.starting_point = starting_point;
        this.destination_point = destination_point;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarting_point() {
        return starting_point;
    }

    public void setStarting_point(String starting_point) {
        this.starting_point = starting_point;
    }

    public String getDestination_point() {
        return destination_point;
    }

    public void setDestination_point(String destination_point) {
        this.destination_point = destination_point;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
