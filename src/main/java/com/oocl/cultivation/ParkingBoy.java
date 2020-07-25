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
        if (parkingLot.getParkCars().size() > parkingLot.getCapacity()) {
            this.setMessage("Not enough position.");
            return null;
        }
        return parkingLot.park(car);
    }

    public Car fetchCar(CarTicket carTicket) {
        if (carTicket == null) {
            this.setMessage("Please provide your parking ticket.");
            return null;
        }
        Car fetchedCar = parkingLot.fetchCar(carTicket);
        if (fetchedCar == null) {
            this.setMessage("Unrecognized parking ticket.");
            return null;
        }
        this.setMessage("");
        return fetchedCar;
    }

}
