package com.scaler.parkinglot.strategies;

import com.scaler.parkinglot.enums.ParkingSpotType;
import com.scaler.parkinglot.models.EntryGate;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.ParkingSpot;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot,
                           ParkingSpotType parkingSpotType,
                           EntryGate entryGate);
}