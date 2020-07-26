package com.oocl.cultivation;

import java.util.LinkedList;

public class ParkManager {
    private ParkStrategy parkStrategy;
    private ParkingLot parkingLot;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ParkManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public ParkStrategy getParkStrategy() {
        return parkStrategy;
    }

    public void setParkStrategy(ParkStrategy parkStrategy) {
        this.parkStrategy = parkStrategy;
    }
    public CarTicket assignBoyToPark(Car car){
        return parkingLot.park(car);
    }

    public Car assignBoyToFetch(CarTicket carTicket){
        if (carTicket == null){
            this.message = "Fetch Error!";
            return null;
        }
        return this.getParkStrategy().fetchCar(carTicket);
    }


    public CarTicket park(Car car){
        return parkingLot.park(car);
    }

    public Car fetch(CarTicket carTicket){
        return parkingLot.getParkCars().remove(carTicket);
    }
}
