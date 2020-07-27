package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy implements ParkStrategy {
    private List<ParkingLot> parkingLots;
    private String message;

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws Exception {
        ParkingLot targetSpace = null;
        for (ParkingLot parkingLot :
                parkingLots) {
            targetSpace = parkingLot;
            if (targetSpace.isFull()) {
                targetSpace = null;
                continue;
            }
            break;
        }
        if (targetSpace == null){
            throw new Exception("Not enough position.");
        }
        return targetSpace.park(car);
    }

    @Override
    public Car fetchCar(CarTicket carTicket) throws Exception {
        Car fetchedCar = null;
        for (ParkingLot parkingLot : parkingLots) {
            fetchedCar = parkingLot.fetchCar(carTicket);
        }
        if (fetchedCar == null) {
            this.setMessage("Unrecognized parking ticket.");
            return null;
        }
        return fetchedCar;
    }

}
