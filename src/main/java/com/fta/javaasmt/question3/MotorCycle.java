package com.fta.javaasmt.question3;

public class MotorCycle extends Vehicle {
    public MotorCycle(){
        spotsNeeded = 1;
        size = VehicleSize.MOTORCYCLE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSizeOfVehicle() == VehicleSize.MOTORCYCLE|| spot.getSizeOfVehicle() == VehicleSize.CARSIZE
                || spot.getSizeOfVehicle() == VehicleSize.LARGE;
    }

}
