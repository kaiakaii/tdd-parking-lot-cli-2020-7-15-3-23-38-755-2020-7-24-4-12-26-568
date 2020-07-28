package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {

    @Test
    void should_carTicket_when_park_given_car() throws Exception {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        Car car = new Car();
        //when
        CarTicket carTicket = parkingBoy.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_car_when_fetch_car_given_car_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetchCar(carTicket);
        //then
        assertNotNull(carTicket);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_car_when_fetch_given_cars() throws Exception {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        Car myCar = new Car();
        Car hisCar = new Car();
        CarTicket myCarTickets = parkingBoy.park(myCar);
        CarTicket hisCarTickets = parkingBoy.park(hisCar);
        //when
        Car mycarFetch = parkingBoy.fetchCar(myCarTickets);
        Car hisCarFetch = parkingBoy.fetchCar(hisCarTickets);
        //then
        assertEquals(mycarFetch, myCar);
        assertEquals(hisCarFetch, hisCar);
    }

    @Test
    void should_null_when_fetch_car_given_wrong_tickets() throws Exception {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        //when
        CarTicket hisTickets = null;
        //then
        assertThrows(Exception.class,()->{
            parkingBoy.fetchCar(hisTickets);
        });
    }

    @Test
    void should_null_when_fetch_car_given_overdue_tickets() throws Exception {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        Car myCar = new Car();
        CarTicket carTicket = parkingBoy.park(myCar);
        //when
        parkingBoy.fetchCar(carTicket);
        //then
        assertThrows(Exception.class,()->{
            parkingBoy.fetchCar(carTicket);
        });
    }

    @Test
    void should_null_when_park_given_car() throws Exception {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(1));
        //when
        parkingBoy.park(new Car());
        //then
        assertThrows(Exception.class,()->{
            parkingBoy.park(new Car());
        });
    }
}
