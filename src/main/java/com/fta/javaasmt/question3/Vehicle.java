package com.fta.javaasmt.question3;

import java.util.ArrayList;

public abstract  class Vehicle {
    protected int spotsNeeded;
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected VehicleSize size;
    protected String registrationNo;

    public int getSpotsNeeded(){
        return spotsNeeded;
    }
    public VehicleSize getSize(){
        return size;
    }

    public void parkInSpot(ParkingSpot s){
        parkingSpots.add(s);
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);

}
