package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket,Car> parkCars = new HashMap<>();
    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkCars.put(carTicket,car);
        return carTicket;
    }

    public Car fetchCar(CarTicket carTicket) {
        if (parkCars.get(carTicket) != null) return parkCars.get(carTicket);
        return null;
    }
}
