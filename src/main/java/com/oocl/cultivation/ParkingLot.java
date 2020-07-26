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
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkCars.put(carTicket, car);
        capacity--;
        return carTicket;
    }

    public Car fetchCar(CarTicket carTicket) {
        Car fetchCar = parkCars.remove(carTicket);
        capacity++;
        return fetchCar;
    }
}
