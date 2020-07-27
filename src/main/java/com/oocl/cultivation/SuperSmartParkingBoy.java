package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        Optional<ParkingLot> parkingLot = this.getParkingLots().stream()
                .max(Comparator
                        .comparing(maxParkingLot -> (maxParkingLot.getCapacity() - maxParkingLot.getParkCars().size()) / maxParkingLot.getCapacity()));
        return parkingLot.get().park(car);
    }
}
