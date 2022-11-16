package com.scaler.parkinglot.dto;

public class UpdateParkingLotRequestDto {
    private Long id;
    private String address;
    private int noOfParkingFloor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNoOfParkingFloor(int noOfParkingFloor) {
        this.noOfParkingFloor = noOfParkingFloor;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getNoOfParkingFloor() {
        return noOfParkingFloor;
    }
}
