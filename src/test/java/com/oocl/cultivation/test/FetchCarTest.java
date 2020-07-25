package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FetchCarTest {
    @Test
    void should_return_unrecognizable_carTicket_when_search_message_given_wrong_carTicket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);
        parkingBoy.fetchCar(carTicket);
        //when
        Car fetchCar = parkingBoy.fetchCar(carTicket);
        //then
        assertNull(fetchCar);
        assertEquals("Unrecognized parking ticket.",parkingBoy.getMessage());
    }
    @Test
    void should_return_null_carTicket_when_search_message_given_wrong_carTicket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        Car car = new Car();
        CarTicket carTicket = null;
        //when
        Car fetchCar = parkingBoy.fetchCar(carTicket);
        //then
        assertEquals("Please provide your parking ticket.",parkingBoy.getMessage());
    }

}
