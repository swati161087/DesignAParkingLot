package com.scaler.parkinglot.services;

import com.scaler.parkinglot.enums.ParkingSpotType;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.strategies.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    public TicketService(TicketRepository ticketRepository,SpotAssignmentStrategy spotAssignmentStrategy,ParkingLotRepository parkingLotRepository){
        this.ticketRepository=ticketRepository;
        this.spotAssignmentStrategy=spotAssignmentStrategy;
        this.parkingLotRepository=parkingLotRepository;
    }
    public Ticket generateTicket(Long parkingLotId, Vehicle vehicle, EntryGate entryGate){
        // get parking lot
        ParkingLot parkingLot= this.parkingLotRepository.getParkingLotById(parkingLotId);
        // find the parking spot.
        ParkingSpot parkingSpot=this.spotAssignmentStrategy.assignSpot(parkingLot, ParkingSpotType.CAR,entryGate);
        if(parkingSpot==null){
            return null;
        }
        Ticket ticket=new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryGate(entryGate);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        return this.ticketRepository.save(ticket);
    }
}
