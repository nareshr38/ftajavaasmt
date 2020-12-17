package com.fta.javaasmt.question3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

public class ParkingUtility {
    private static final Logger logger = LogManager.getLogger(ParkingUtility.class.getName());

    public static void main(String[] args) {
        final String parkingInformation = "Please enter bus, car, or motorcycle a vehicle (enter 0 to exit):";

        ParkingLot parkingLot = new ParkingLot();
        String inputData = "";
        Scanner input = new Scanner(System.in);

        logger.info("The empty parking lot");
        logger.info(parkingLot.toString());

        logger.info(parkingInformation);
        inputData = input.next();

        while (!inputData.equals("0")) {
            if (inputData.equals("Bus") || inputData.equals("bus")) {
                Bus bus = new Bus();

                if (parkingLot.parkVehicle(bus)) {

                    logger.info("The bus has been parked successfully.");
                    logger.info(parkingLot.toString());
                    logger.info(parkingInformation);
                    inputData = input.next();
                } else {
                    logger.info("Parking Failed: Bus spots are full");
                    logger.info(parkingInformation);
                    inputData = input.next();
                }
            } else if (inputData.equals("Car") || inputData.equals("car")) {
                Car c = new Car();

                if (parkingLot.parkVehicle(c)) {
                    logger.info("The car has been parked successfully.");
                    logger.info(parkingLot.toString());
                    logger.info(parkingInformation);
                    inputData = input.next();
                } else {
                    logger.info("Parking Failed: large spots are full");
                    logger.info(parkingInformation);
                    inputData = input.next();
                }
            } else if (inputData.equals("Motorcycle") || inputData.equals("motorcycle")) {
                MotorCycle m = new MotorCycle();

                if (parkingLot.parkVehicle(m)) {
                    logger.info("The motorcycle has been parked successfully.");
                    logger.info(parkingLot.toString());
                    logger.info(parkingInformation);
                    inputData = input.next();

                } else {
                    logger.info("Parking Failed: Motorcycle spots are full");
                    logger.info(parkingInformation);
                    inputData = input.next();
                }
            } else {
                logger.info("Invalid input.");
                logger.info(parkingInformation);
                inputData = input.next();
            }
            if (inputData.equals("0")) {
                logger.info("Program terminated");
                break;
            }
        }
    }


}
