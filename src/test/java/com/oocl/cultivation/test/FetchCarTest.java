package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FetchCarTest {
    private List<ParkingLot> parkingLots;
    @BeforeAll
    void init(){
        parkingLots = new LinkedList<>();
    }
    @Test
    void should_return_unrecognizable_carTicket_when_search_message_given_wrong_carTicket() throws Exception {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
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
    void should_return_null_carTicket_when_search_message_given_wrong_carTicket() throws Exception {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        Car car = new Car();
        CarTicket carTicket = null;
        //todo wrong ticket his ticket to fetch my car
        //when
        Car fetchCar = parkingBoy.fetchCar(carTicket);
        //then
        assertEquals("Please provide your parking ticket.",parkingBoy.getMessage());
    }

}
