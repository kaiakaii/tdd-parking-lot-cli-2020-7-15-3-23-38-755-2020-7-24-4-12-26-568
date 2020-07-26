package com.oocl.cultivation;

import java.util.LinkedList;

public class ParkManager {
    private ParkStrategy parkStrategy;

    public ParkStrategy getParkStrategy() {
        return parkStrategy;
    }

    public void setParkStrategy(ParkStrategy parkStrategy) {
        this.parkStrategy = parkStrategy;
    }

    public CarTicket park(Car car){
        return parkStrategy.park(car);
    }
}
