package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetchCar(CarTicket carTicket) {
        if (carTicket == null) return null;
        return parkingLot.fetchCar(carTicket);
    }
}
