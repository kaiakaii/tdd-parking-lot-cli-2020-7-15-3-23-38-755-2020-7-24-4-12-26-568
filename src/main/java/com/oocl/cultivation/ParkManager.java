package com.oocl.cultivation;


import java.util.Arrays;
import java.util.List;

public class ParkManager {
    private List<ParkStrategy> parkBoys;

    public ParkManager(ParkStrategy...parkBoys) {
        this.parkBoys = Arrays.asList(parkBoys);
    }

    public List<ParkStrategy> getParkBoys() {
        return parkBoys;
    }


}
