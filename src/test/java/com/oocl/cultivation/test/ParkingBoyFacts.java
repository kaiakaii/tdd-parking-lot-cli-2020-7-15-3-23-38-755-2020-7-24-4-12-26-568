package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyFacts {
    @Test
    void should_carTicket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        CarTicket carTicket = parkingLot.park(car);
        //then
        assertNotNull(carTicket);
    }
    @Test
    void should_car_when_fetch_car_given_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);
        //when
        Car fetchedCar = parkingLot.fetchCar(carTicket);
        //then
        assertNotNull(carTicket);
        assertEquals(car,fetchedCar);
    }

    @Test
    void should_car_when_fetch_given_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Map<CarTicket,Car> parkCars = new HashMap<>();
        Car myCar = new Car();
        CarTicket carTickets = parkingLot.park(myCar);
        parkCars.put(new CarTicket(),new Car());
        parkCars.put(carTickets,myCar);
        //when
        Car car = parkingLot.fetchCar(carTickets);
        //then
        assertEquals(car,myCar);
    }
}
