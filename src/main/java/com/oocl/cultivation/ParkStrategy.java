package com.oocl.cultivation;

public interface ParkStrategy {
    CarTicket park(Car car) throws Exception;
    Car fetchCar(CarTicket carTicket) throws Exception;
}
