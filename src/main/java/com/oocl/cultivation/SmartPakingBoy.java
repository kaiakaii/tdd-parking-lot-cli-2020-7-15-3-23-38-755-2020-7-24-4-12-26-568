package com.oocl.cultivation;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartPakingBoy extends ParkingBoy {
    public SmartPakingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        //todo valid
        Optional<ParkingLot> parkingLot = this.getParkingLots().stream().max(Comparator.comparing(ParkingLot::getCapacity));
        return parkingLot.get().park(car);
    }
}
