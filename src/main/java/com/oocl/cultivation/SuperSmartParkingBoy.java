package com.oocl.cultivation;

import java.util.Collection;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(Collection<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        return super.park(car);
    }
}
