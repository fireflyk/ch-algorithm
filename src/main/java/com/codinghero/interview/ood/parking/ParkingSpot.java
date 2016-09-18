package com.codinghero.interview.ood.parking;

public abstract class ParkingSpot {

    private Integer spotId;

    private Car car;

    protected CarSize size;

    public Integer getSpotId() {
        return spotId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarSize getSize() {
        return size;
    }
}
