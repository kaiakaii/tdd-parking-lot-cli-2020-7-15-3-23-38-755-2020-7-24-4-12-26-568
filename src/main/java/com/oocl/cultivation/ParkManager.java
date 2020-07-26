package com.oocl.cultivation;

import java.util.LinkedList;

public class ParkManager {
    private ParkStrategy parkStrategy;
    private ParkingLot parkingLot;

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

    public CarTicket park(Car car){
        return parkingLot.park(car);
    }
    public Car fetch(CarTicket carTicket){
        return parkingLot.getParkCars().remove(carTicket);
    }
}
