package com.oocl.cultivation;

import com.oocl.cultivation.exception.NoEnoughException;
import com.oocl.cultivation.exception.UnrecognizedTicketException;

import java.util.List;

public class ParkingBoy implements ParkStrategy {
    private List<ParkingLot> parkingLots;

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws Exception {
        ParkingLot targetSpace = null;
        for (ParkingLot parkingLot :
                parkingLots) {
            targetSpace = parkingLot;
            if (targetSpace.isFull()) {
                targetSpace = null;
                continue;
            }
            break;
        }
        if (targetSpace == null){
            throw new NoEnoughException("Not enough position.");
        }
        return targetSpace.park(car);
    }

    @Override
    public Car fetchCar(CarTicket carTicket) throws Exception {
        Car fetchedCar = null;
        for (ParkingLot parkingLot : parkingLots) {
            fetchedCar = parkingLot.fetchCar(carTicket);
        }
        if (fetchedCar == null) {
            throw new UnrecognizedTicketException("Unrecognized parking ticket.");
        }
        return fetchedCar;
    }

}
