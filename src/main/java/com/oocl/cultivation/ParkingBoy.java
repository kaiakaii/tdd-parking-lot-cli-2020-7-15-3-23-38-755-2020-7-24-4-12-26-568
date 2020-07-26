package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Collection;

public class ParkingBoy implements ParkStrategy {
    private Collection<ParkingLot> parkingLots;
    private String message;

    public Collection<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ParkingBoy(Collection<ParkingLot> parkingLots) {
        this.parkingLots = new ArrayList<>();
    }

    public CarTicket park(Car car) {
        ParkingLot targetSpace = null;
        for (ParkingLot parkingLot:
             parkingLots) {
            targetSpace = parkingLot;
            if(parkingLot.getParkCars().size() > parkingLot.getCapacity()){
                targetSpace = null;
                continue;
            }
            break;
        }
        if (targetSpace == null){
            this.setMessage("Not enough position.");
            return null;
        }
//        if (parkingLot.getParkCars().size() > parkingLot.getCapacity()) {
//            this.setMessage("Not enough position.");
//            return null;
//        }
        return targetSpace.park(car);
    }

    public Car fetchCar(CarTicket carTicket) {
        if (carTicket == null) {
            this.setMessage("Please provide your parking ticket.");
            return null;
        }
        Car fetchedCar = null;
        for (ParkingLot parkingLot:parkingLots) {
            fetchedCar = parkingLot.fetchCar(carTicket);
        }
        if (fetchedCar == null) {
            this.setMessage("Unrecognized parking ticket.");
            return null;
        }
        return fetchedCar;
    }

}
