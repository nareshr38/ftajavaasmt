package com.fta.javaasmt.question3;

public class ParkingSpot {
    private int row;
    private int numberOfSpots;
    private VehicleSize sizeOfVehicle;
    private Level parkingLevel;
    private Vehicle vehicle;


    public ParkingSpot(Level level, int rowA, int count, VehicleSize sz) {
        row = rowA;
        numberOfSpots = count;
        sizeOfVehicle = sz;
        parkingLevel = level;
    }

    public int getRow() {
        return row;
    }

    public int getNumberOfSpots() {
        return numberOfSpots;
    }

    public VehicleSize getSizeOfVehicle() {
        return sizeOfVehicle;
    }

    public boolean isAvailable()
    {
        return (vehicle==null);
    }

    public boolean fitVehicle ( Vehicle vehicle)
    {
        return vehicle.canFitInSpot(this) && isAvailable();
    }

    public boolean park( Vehicle vehicle1)
    {
        if(!fitVehicle(vehicle1))
        {
            return false;
        }
        vehicle =vehicle1;
        vehicle.parkInSpot(this);
        return true;
    }
    public void rvVehicle(){
        parkingLevel.spotFreed();
        vehicle = null;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        if(!isAvailable()){
            if(vehicle.getSize() == VehicleSize.LARGE){
                stringBuilder.append('B');
            } else if (vehicle.getSize() == VehicleSize.CARSIZE){
                stringBuilder.append('C');
            } else {
                stringBuilder.append('M');
            }
        } else {
            if(sizeOfVehicle == VehicleSize.LARGE){
                stringBuilder.append('_');
            } else if (sizeOfVehicle == VehicleSize.CARSIZE){
                stringBuilder.append('.');
            } else {
                stringBuilder.append(',');
            }
        }

        return stringBuilder.toString();
    }



}
