package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
