package com.codinghero.algorithm;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int cityCount, int[][] flights, int src, int dest, int maxStop) {
        Queue<Integer> nextCities = new LinkedList<>();
        nextCities.add(src);
        Set<Integer> visitedCities = new HashSet<>();
        visitedCities.add(src);
        Integer[] costs = buildCosts(cityCount, dest);
        ArrayList<LinkedList<FlightInfo>> allFlightsInfo = buildAllFlightsInfo(flights, cityCount);
        for (int i = 0; i < maxStop; i++) {
            Queue<Integer> tempNextCities = new LinkedList<>();
            for (int curCity : nextCities) {
                for (FlightInfo flightInfo : allFlightsInfo.get(curCity)) {
                    if (costs[curCity] != null) {
                        if (costs[flightInfo.dest] == null
                            || costs[curCity] + flightInfo.price < costs[flightInfo.dest]) {
                            costs[flightInfo.dest] = costs[curCity] + flightInfo.price;
                            if (!visitedCities.contains(flightInfo.dest)) {
                                tempNextCities.add(flightInfo.dest);
                            }
                        }
                    }

                }
            }
            nextCities = tempNextCities;
        }
        return costs[dest];
    }

    private Integer[] buildCosts(int cityCount, int src) {
        Integer[] costs = new Integer[cityCount];
        costs[src] = 0;
        return costs;
    }

    private ArrayList<LinkedList<FlightInfo>> buildAllFlightsInfo(int[][] flights, int cityCount) {
        ArrayList<LinkedList<FlightInfo>> allFlightsInfo = new ArrayList<>();
        for (int i = 0; i < cityCount; i++) {
            allFlightsInfo.add(new LinkedList<>());
        }
        for (int[] flight : flights) {
            allFlightsInfo.get(flight[0]).add(new FlightInfo(flight[1], flight[2]));
        }
        return allFlightsInfo;
    }

    private class FlightInfo {
        private int dest;
        private int price;

        private FlightInfo(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }
    }
}
