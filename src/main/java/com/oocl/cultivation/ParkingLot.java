package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkCars = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        if (parkCars.size() > capacity) return null;
        CarTicket carTicket = new CarTicket();
        parkCars.put(carTicket, car);
        return carTicket;
    }

    public Car fetchCar(CarTicket carTicket) {
        return parkCars.remove(carTicket);
    }
}
