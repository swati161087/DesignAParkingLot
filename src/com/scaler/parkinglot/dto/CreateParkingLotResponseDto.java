package com.scaler.parkinglot.dto;

import com.scaler.parkinglot.models.ParkingLot;

public class CreateParkingLotResponseDto {
    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
