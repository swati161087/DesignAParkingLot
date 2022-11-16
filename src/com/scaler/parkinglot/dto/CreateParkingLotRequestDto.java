package com.scaler.parkinglot.dto;

public class CreateParkingLotRequestDto {
    private String address;
    private int numberOfFloors;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
