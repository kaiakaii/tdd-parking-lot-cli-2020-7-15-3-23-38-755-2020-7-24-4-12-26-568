package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkCars = new HashMap<>();
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public Map<CarTicket, Car> getParkCars() {
        return parkCars;
    }

    public ParkingLot(int capacity) {
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkCars.put(carTicket, car);
        return carTicket;
    }

    public Car fetchCar(CarTicket carTicket) {
        return parkCars.remove(carTicket);
    }
}
