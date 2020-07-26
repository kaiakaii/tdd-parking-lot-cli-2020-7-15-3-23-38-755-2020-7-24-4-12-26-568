package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParkCarTest {
    private Collection<ParkingLot> parkingLots;
    @BeforeAll
    void init(){
        parkingLots = new LinkedList<>();
    }
    @Test
    void should_return_not_enough_position_when_park_given_full_parking_space() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        for (int i = 0; i < 11; i++) {
            parkingBoy.park(new Car());
        }
        //when
        parkingBoy.park(new Car());
        //then
        assertEquals("Not enough position.",parkingBoy.getMessage());
    }
    @Test
    void should_return_park_car_in_next_parklot_position_when_park_given_full_parking_space() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        parkingBoy.getParkingLots().add(new ParkingLot(10));
        for (int i = 0; i < 11; i++) {
            parkingBoy.park(new Car());
        }
        //when
        CarTicket carTicket = parkingBoy.park(new Car());
        //then
        assertNotNull(carTicket);
    }
    @Test
    void should_return_park_in_more_open_spaces_when_park_given_car() {
        //given
        ParkingBoy smartParkingBoy = new SmartPakingBoy(new LinkedList<ParkingLot>());
        ParkingLot smallParkingLot = new ParkingLot(10);
        ParkingLot bigParkingLot = new ParkingLot(15);
        smartParkingBoy.getParkingLots().add(smallParkingLot);
        smartParkingBoy.getParkingLots().add(bigParkingLot);
        Car myCar = new Car();
        //when
        CarTicket carTicket = smartParkingBoy.park(myCar);
        //then
        assertEquals(myCar,bigParkingLot.getParkCars().get(carTicket));
    }
}
