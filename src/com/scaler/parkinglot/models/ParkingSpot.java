package com.scaler.parkinglot.models;

import com.scaler.parkinglot.enums.ParkingSpotStatus;
import com.scaler.parkinglot.enums.ParkingSpotType;

public class ParkingSpot extends BaseModel {
    private ParkingSpotType parkingSpotType;
    private int parkingSpotNo;
    private ParkingSpotStatus parkingSpotStatus;

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public int getParkingSpotNo() {
        return parkingSpotNo;
    }

    public void setParkingSpotNo(int parkingSpotNo) {
        this.parkingSpotNo = parkingSpotNo;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
}
