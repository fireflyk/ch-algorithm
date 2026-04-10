package com.codinghero.interview.ood.parking;

public abstract class Car {

    private String id;
    
    protected CarSize size;

    public String getId() {
        return id;
    }
    
    public CarSize getSize() {
        return size;
    }
}
