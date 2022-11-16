package com.scaler.parkinglot;

import com.scaler.parkinglot.controllers.ParkingLotController;
import com.scaler.parkinglot.controllers.TicketController;
import com.scaler.parkinglot.dto.CreateParkingLotRequestDto;
import com.scaler.parkinglot.dto.CreateParkingLotResponseDto;
import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.UpdateParkingLotRequestDto;
import com.scaler.parkinglot.models.EntryGate;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.services.ParkingLotService;
import com.scaler.parkinglot.services.TicketService;
import com.scaler.parkinglot.strategies.RandomSpotAssignmentStrategy;
import com.scaler.parkinglot.strategies.SpotAssignmentStrategy;

public class Client {
    public static void main(String[] args) {
        ObjectRegistry.put("ParkingLotRepository",new ParkingLotRepository());

        ObjectRegistry.put("ParkingLotService",new ParkingLotService((ParkingLotRepository)
                                    ObjectRegistry.get("ParkingLotRepository")));

        ObjectRegistry.put("ParkingLotController",new ParkingLotController(
                        (ParkingLotService)ObjectRegistry.get("ParkingLotService")));

        ObjectRegistry.put("TicketRepository",new TicketRepository());
        ObjectRegistry.put("SpotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.put("TicketService",new TicketService(
                (TicketRepository)ObjectRegistry.get("TicketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("SpotAssignmentStrategy"),
                (ParkingLotRepository) ObjectRegistry.get("ParkingLotRepository")
        ));
        ObjectRegistry.put("TicketController",new TicketController(
                        (TicketService) ObjectRegistry.get("TicketService")));

        ParkingLotController parkingLotController=(ParkingLotController)ObjectRegistry.get("ParkingLotController");
        TicketController ticketController=(TicketController)ObjectRegistry.get("TicketController");

        CreateParkingLotRequestDto createParkingLotRequestDto=new CreateParkingLotRequestDto();

        createParkingLotRequestDto.setAddress("Noida");

        createParkingLotRequestDto.setNumberOfFloors(2);

        CreateParkingLotResponseDto createParkingLotResponseDto=parkingLotController.createParkingLot(createParkingLotRequestDto);
        UpdateParkingLotRequestDto updateParkingLotRequestDto=new UpdateParkingLotRequestDto();
        updateParkingLotRequestDto.setAddress("Delhi");
        updateParkingLotRequestDto.setNoOfParkingFloor(4);
        updateParkingLotRequestDto.setId((long) 1);
        parkingLotController.updateParkingLot(updateParkingLotRequestDto);
        GenerateTicketRequestDto generateTicketRequestDto=new GenerateTicketRequestDto();
        generateTicketRequestDto.setEntryGate(new EntryGate());
        generateTicketRequestDto.setVehicle(new Vehicle());
        generateTicketRequestDto.setParkingLotId((long)1);
        ticketController.generateTicket(generateTicketRequestDto);
        System.out.println(createParkingLotResponseDto.getParkingLot().getAddress());
    }

}
