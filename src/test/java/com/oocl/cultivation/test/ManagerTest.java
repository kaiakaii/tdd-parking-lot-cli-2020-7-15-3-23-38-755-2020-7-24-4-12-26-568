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
public class ManagerTest {
    private List<ParkingLot> parkingLots;
    @BeforeAll
    void init(){
        parkingLots = new LinkedList<>();
    }
    @Test
    void should_return_car_when_park_given_manager_assign_boy() {
        //given
        this.parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy smartPakingBoy = new SmartPakingBoy(parkingLots);
        ParkManager parkManager = new ParkManager(parkingBoy,parkingLot,smartPakingBoy);
        Car myCar = new Car();
        //when
        CarTicket carTicket = parkManager.getParkBoys().get(0).park(myCar);
        //then
        assertNotNull(carTicket);

    }
    @Test
    void should_return_car_when_fetch_given_manager() {
        //given
        this.parkingLots.add(new ParkingLot(1));
        ParkingLot parkingLot = new ParkingLot(1);
        ParkManager parkManager = new ParkManager(parkingLot);
        Car car = new Car();
        CarTicket carTicket = parkManager.getParkBoys().get(0).park(car);
        //when
        Car myCar = parkManager.getParkBoys().get(0).fetchCar(carTicket);
        //then
        assertEquals(car,myCar);
    }
    @Test
    void should_return_error_message_when_park_given_parking_error() {
        //given
        this.parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy smartPakingBoy = new SmartPakingBoy(parkingLots);
        ParkManager parkManager = new ParkManager(parkingBoy,parkingLot,smartPakingBoy);
        Car car = new Car();
        CarTicket carTicket = null;
        //when
        Car myCar = parkManager.getParkBoys().get(2).fetchCar(carTicket);
        //then
        assertEquals("Fetch Error!",parkManager.getMessage());
    }
}
