package com.oocl.cultivation;

import com.oocl.cultivation.exception.NullTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements ParkStrategy {
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

    @Override
    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        this.parkCars.put(carTicket, car);
        return carTicket;
    }

    public boolean isFull() {
        return this.parkCars.size() >= this.capacity;
    }

    @Override
    public Car fetchCar(CarTicket carTicket) throws Exception {
        if(carTicket == null){
            throw new NullTicketException("Please provide your parking ticket.");
        }
        return parkCars.remove(carTicket);
    }
}
