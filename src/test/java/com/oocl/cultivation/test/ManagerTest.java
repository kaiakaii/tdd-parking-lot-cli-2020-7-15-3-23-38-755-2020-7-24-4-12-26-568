package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ManagerTest {
    private List<ParkingLot> parkingLots;
    @BeforeAll
    void init(){
        parkingLots = new LinkedList<>();
    }
    @Test
    void should_return_car_when_park_given_manager_assign_boy() {
        //given
        ParkManager parkManager = new ParkManager();
        this.parkingLots.add(new ParkingLot(10));
        parkManager.setParkStrategy(new ParkingBoy(this.parkingLots));
        Car myCar = new Car();
        //when
        CarTicket carTicket = parkManager.getParkStrategy().park(myCar);
        //then
        assertNotNull(carTicket);

    }
}
