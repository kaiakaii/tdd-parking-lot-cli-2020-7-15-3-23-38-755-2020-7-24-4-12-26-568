package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
        CarTicket myCarTickets = parkingLot.park(myCar);
        parkCars.put(new CarTicket(),new Car());
        parkCars.put(myCarTickets,myCar);
        //when
        Car car = parkingLot.fetchCar(myCarTickets);
        //then
        assertEquals(car,myCar);
    }

    @Test
    void should_null_when_fetch_car_given_wrong_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        CarTicket hisTickets = null;
        //when
        Car car = parkingLot.fetchCar(hisTickets);
        //then
        assertEquals(null,car);
    }

    @Test
    void should_null_when_fetch_car_given_overdue_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car myCar = new Car();
        CarTicket carTicket = parkingLot.park(myCar);
        parkingLot.fetchCar(carTicket);
        //when
        Car car = parkingLot.fetchCar(carTicket);
        //then
        assertEquals(null,car);
    }
}
