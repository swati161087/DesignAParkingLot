package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.repositories.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository=parkingLotRepository;
    }
    public ParkingLot createParkingLot(ParkingLot parkingLot){
    return parkingLotRepository.save(parkingLot);
    }
    public ParkingLot updateParkingLotById(Long id,ParkingLot parkingLotToUpdate){
       ParkingLot parkingLot= parkingLotRepository.getParkingLotById(id);
       parkingLot.setAddress(parkingLotToUpdate.getAddress());
       parkingLot.setParkingFloors(parkingLotToUpdate.getParkingFloors());
        return parkingLotRepository.updateById(id,parkingLot);
    }
}
