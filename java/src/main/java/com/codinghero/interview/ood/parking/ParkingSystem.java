package com.codinghero.interview.ood.parking;

import java.util.LinkedList;
import java.util.List;

public class ParkingSystem {

    private List<ParkingSpot> smallAvailablePakringSpots;

    private List<ParkingSpot> middleAvailablePakringSpots;

    private List<ParkingSpot> largeAvailablePakringSpots;

    private List<ParkingSpot> smallUnavailablePakringSpots;

    private List<ParkingSpot> middleUnavailablePakringSpots;

    private List<ParkingSpot> largeUnavailablePakringSpots;

    public ParkingSystem() {
        smallAvailablePakringSpots = new LinkedList<ParkingSpot>();
        middleAvailablePakringSpots = new LinkedList<ParkingSpot>();
        largeAvailablePakringSpots = new LinkedList<ParkingSpot>();
        smallUnavailablePakringSpots = new LinkedList<ParkingSpot>();
        middleUnavailablePakringSpots = new LinkedList<ParkingSpot>();
        largeUnavailablePakringSpots = new LinkedList<ParkingSpot>();
        // TODO
    }

    public ParkingTicket park(Car car) {
        // TODO
        if (CarSize.SMALL.equals(car.getSize()) && !smallAvailablePakringSpots.isEmpty()) {
            return null;
        } else if ((CarSize.SMALL.equals(car.getSize()) || CarSize.MIDDLE.equals(car.getSize())) && !middleAvailablePakringSpots.isEmpty()) {
            return null;
        } else if (!largeAvailablePakringSpots.isEmpty()) {
            return null;
        } else {
            return null;
        }
    }

    public Car leave(ParkingTicket parkingTicket) {
        // TODO
        return null;
    }
}
