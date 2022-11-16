package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dto.CreateParkingLotRequestDto;
import com.scaler.parkinglot.dto.CreateParkingLotResponseDto;
import com.scaler.parkinglot.dto.UpdateParkingLotRequestDto;
import com.scaler.parkinglot.dto.UpdateParkingLotResponseDto;
import com.scaler.parkinglot.enums.ParkingSpotStatus;
import com.scaler.parkinglot.enums.ParkingSpotType;
import com.scaler.parkinglot.models.ParkingFloor;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLotService;
  //  private ParkingLotService=new ParkingLotService(); we can use dependency injection.

    public ParkingLotController(ParkingLotService parkingLotService){
        this.parkingLotService=parkingLotService;
    }
    public CreateParkingLotResponseDto createParkingLot(CreateParkingLotRequestDto createParkingLotRequestDto)
    {
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setAddress(createParkingLotRequestDto.getAddress());
        parkingLot.setParkingFloors(List.of(new ParkingFloor(),new ParkingFloor()));
        ParkingLot newParkingLot=parkingLotService.createParkingLot(parkingLot);
        CreateParkingLotResponseDto createParkingLotResponseDto=new CreateParkingLotResponseDto();
        createParkingLotResponseDto.setParkingLot(parkingLot);
        return  createParkingLotResponseDto;
    }
    public UpdateParkingLotResponseDto updateParkingLot(UpdateParkingLotRequestDto updateParkingLotRequestDto)
    {
        ParkingLot parkingLot=new ParkingLot();
        List<ParkingFloor> parkingFloors=new ArrayList();
        for(int i=0;i<updateParkingLotRequestDto.getNoOfParkingFloor();i++)
        {
            ParkingFloor parkingFloor=new ParkingFloor();
            List<ParkingSpot> parkingSpots=new ArrayList<>();
            for(int j=0;j<3;j++)
            {
                ParkingSpot parkingSpot=new ParkingSpot();
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.VACANT);
                parkingSpot.setParkingSpotType(ParkingSpotType.CAR);
                parkingSpots.add(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpots);
            parkingFloors.add(parkingFloor);

        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLot.setAddress(updateParkingLotRequestDto.getAddress());
        parkingLotService.updateParkingLotById(updateParkingLotRequestDto.getId(),parkingLot);
        return null;
    }
}
