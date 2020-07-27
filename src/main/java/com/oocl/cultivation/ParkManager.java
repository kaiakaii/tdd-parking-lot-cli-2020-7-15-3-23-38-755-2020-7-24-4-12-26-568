package com.oocl.cultivation;


import java.util.Arrays;
import java.util.List;

public class ParkManager {
    private List<ParkStrategy> parkBoys;
    private ParkingLot parkingLot;
    private String message;

    public String getMessage() {
        return message;
    }

    public ParkManager(ParkStrategy...parkBoys) {
        this.parkBoys = Arrays.asList(parkBoys);
    }

    public List<ParkStrategy> getParkBoys() {
        return parkBoys;
    }

//    public CarTicket assignBoyToPark(Car car){
//        return parkingLot.park(car);
//    }

//    public Car assignBoyToFetch(CarTicket carTicket){
//        if (carTicket == null){
//            this.message = "Fetch Error!";
//            return null;
//        }
//        return this.getParkStrategy().fetchCar(carTicket);
//    }

}
