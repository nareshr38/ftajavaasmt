package com.fta.javaasmt.question3;


public class ParkingLot {
    private Level[] levels;
    private static final int NUMBEROFLEVELS = 2;

    public ParkingLot() {
        levels = new Level[NUMBEROFLEVELS];
        for (int count = 0; count < NUMBEROFLEVELS; count++) {
            levels[count] = new Level(20);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (int count = 0; count < levels.length; count++) {
            if (levels[count].parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int count = 0; count < NUMBEROFLEVELS; count++) {
            sb.append("Level " + count + ": " + levels[count] + "\n");
        }
        return sb.toString();
    }

}
