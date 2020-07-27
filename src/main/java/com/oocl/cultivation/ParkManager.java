package com.oocl.cultivation;


public class ParkManager {
    private ParkStrategy parkStrategy;
    private ParkingLot parkingLot;
    private String message;

    public String getMessage() {
        return message;
    }

    public ParkManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
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
