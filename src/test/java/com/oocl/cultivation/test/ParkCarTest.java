package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParkCarTest {
    private List<ParkingLot> parkingLots;
    @BeforeAll
    void init(){
        parkingLots = new LinkedList<>();
    }
    @Test
    void should_return_not_enough_position_when_park_given_full_parking_space() throws Exception {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(1));
        //when
        parkingBoy.park(new Car());
        //then
        assertThrows(Exception.class,()->{
            parkingBoy.park(new Car());
        });
    }
    @Test
    void should_return_park_car_in_next_parklot_position_when_park_given_full_parking_space()throws Exception {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.getParkingLots().add(new ParkingLot(1));
        parkingBoy.getParkingLots().add(new ParkingLot(2));
        parkingBoy.park(new Car());
        //when
        CarTicket carTicket = parkingBoy.park(new Car());
        //then
        assertNotNull(carTicket);
    }
    @Test
    void should_return_park_in_more_open_spaces_when_smart_boy_park_given_car() throws Exception{
        //given
        ParkingBoy smartParkingBoy = new SmartPakingBoy(new LinkedList<>());
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
    @Test
    void should_return_park_larger_available_position_when_super_smart_boy_park_given_car()throws Exception {
        //given
        ParkingBoy superParkingBoy = new SuperSmartParkingBoy(new LinkedList<>());
        ParkingLot smallParkingLot = new ParkingLot(10);
        ParkingLot bigParkingLot = new ParkingLot(15);
        superParkingBoy.getParkingLots().add(smallParkingLot);
        superParkingBoy.getParkingLots().add(bigParkingLot);
        smallParkingLot.park(new Car());
        for (int i=0;i<6;i++){
            bigParkingLot.park(new Car());
        }
        Car myCar = new Car();
        //when
        CarTicket carTicket = superParkingBoy.park(myCar);
        //then
        assertEquals(myCar,smallParkingLot.getParkCars().get(carTicket));
    }
}
