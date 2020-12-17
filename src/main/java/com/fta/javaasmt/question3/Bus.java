package com.fta.javaasmt.question3;

public class Bus extends Vehicle {

    public Bus(){
            spotsNeeded = 5;
            size = VehicleSize.LARGE;

        }

        @Override
        public boolean canFitInSpot(ParkingSpot spot) {

        return spot.getSizeOfVehicle() == VehicleSize.LARGE;
        }

    }
