package com.oocl.cultivation;

public interface ParkStrategy {
    CarTicket park(Car car);
    Car fetchCar(CarTicket carTicket);
}
