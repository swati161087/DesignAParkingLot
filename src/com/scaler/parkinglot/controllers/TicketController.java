package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService=ticketService;
    }
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto)
    {
        Ticket ticket= this.ticketService.generateTicket(generateTicketRequestDto.getParkingLotId(),generateTicketRequestDto.getVehicle(),generateTicketRequestDto.getEntryGate());
        GenerateTicketResponseDto generateTicketResponseDto =new GenerateTicketResponseDto();
      return null;
    }
}
