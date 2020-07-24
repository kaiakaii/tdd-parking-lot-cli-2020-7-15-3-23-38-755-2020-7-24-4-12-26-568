package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket,Car> parkCars = new HashMap<>();
    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkCars.put(carTicket,car);
//        carTicket.setOverdue(true);
        return carTicket;
    }

    public Car fetchCar(CarTicket carTicket) {
        if (carTicket == null) return null;
        if (carTicket.isOverdue())return null;
        carTicket.setOverdue(true);
        return parkCars.get(carTicket);
    }
}
