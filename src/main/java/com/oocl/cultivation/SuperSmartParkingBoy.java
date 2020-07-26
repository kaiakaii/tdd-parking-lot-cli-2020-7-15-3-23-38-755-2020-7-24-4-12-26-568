package com.oocl.cultivation;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy implements ParkStrategy{
    public SuperSmartParkingBoy(Collection<ParkingLot> parkingLots) {
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
