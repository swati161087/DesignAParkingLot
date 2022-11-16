package com.scaler.parkinglot.strategies;

import com.scaler.parkinglot.enums.ParkingSpotStatus;
import com.scaler.parkinglot.enums.ParkingSpotType;
import com.scaler.parkinglot.models.EntryGate;
import com.scaler.parkinglot.models.ParkingFloor;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.ParkingSpot;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, ParkingSpotType parkingSpotType, EntryGate entryGate) {
        for(ParkingFloor parkingFloor:parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot:parkingFloor.getParkingSpots())
            {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.VACANT)
                        && parkingSpot.getParkingSpotType().equals(parkingSpotType)) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
