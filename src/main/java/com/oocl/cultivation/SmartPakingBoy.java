package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartPakingBoy extends ParkingBoy {
    public SmartPakingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        Optional<ParkingLot> parkingLot = this.getParkingLots().stream().max(Comparator.comparing(ParkingLot::getCapacity));
        CarTicket carTicket = null;
        try {
            carTicket =  parkingLot.get().park(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carTicket;
    }
}
