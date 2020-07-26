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
public class ManagerTest {
    private Collection<ParkingLot> parkingLots;
    @BeforeAll
    void init(){
        parkingLots = new LinkedList<>();
    }
    @Test
    void should_return_car_when_park_given_manager_assign_boy() {
        //given
        ParkManager parkManager = new ParkManager();
        parkingLots.add(new ParkingLot(10));
        parkManager.setParkStrategy(new ParkingBoy(parkingLots));
        Car myCar = new Car();
        //when
        CarTicket carTicket = parkManager.park(myCar);
        //then
        assertNotNull(carTicket);

    }
}
