package com.fta.javaasmt.question3;

public class Level {

    private ParkingSpot[] parkingSpots;
    private int availableSpots = 0;
    private static final int SPOTPERROW = 10;

    public Level(int numberSpots) {

        availableSpots = numberSpots;
        parkingSpots = new ParkingSpot[numberSpots];


        int largeSpots = numberSpots / 4;
        int bikeSpots = numberSpots / 4;
        int compactSpots = numberSpots - largeSpots - bikeSpots;

        for (int count = 0; count < numberSpots; count++) {
            VehicleSize size = VehicleSize.MOTORCYCLE;
            if (count < largeSpots) {
                size = VehicleSize.LARGE;
            } else if (count < largeSpots + compactSpots) {
                size = VehicleSize.CARSIZE;
            }
            int row = count / SPOTPERROW;
            parkingSpots[count] = new ParkingSpot(this, row, count, size);
        }
    }

    public int availableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        int spotNumber = findAvailableSpots(vehicle);
        if (availableSpots() < vehicle.getSpotsNeeded())
            return false;

        if (spotNumber < 0)
            return false;

        return parkStartingAtSpot(spotNumber, vehicle);
    }

    private boolean parkStartingAtSpot(int number, Vehicle vehicle) {
        boolean success = true;
        for (int index = number; index < number + vehicle.spotsNeeded; index++) {
            success = success && parkingSpots[index].park(vehicle);
        }
        availableSpots = availableSpots - vehicle.spotsNeeded;
        return success;
    }

    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        int sportMediumOne = 0;

        for (int index = 0; index < parkingSpots.length; index++) {


            if (lastRow != parkingSpots[index].getRow()) {
                spotsFound = 0;
                lastRow = parkingSpots[index].getRow();
            }

            if (parkingSpots[index].fitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            sportMediumOne = spotsNeeded - 1;

            if (spotsFound == spotsNeeded) {
                return (index - sportMediumOne);
            }
        }
        return -1;
    }

    public void spotFreed() {
        availableSpots++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int count = 0; count < parkingSpots.length; count++) {
            if (count == 10 || count == 20) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(parkingSpots[count]);
        }
        return stringBuilder.toString();
    }

}
