package controllers;

import dtos.GenerateTicketRequestDTO;
import dtos.GenerateTicketResponseDTO;
import dtos.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestDTO){
        GenerateTicketResponseDTO responseDTO = new GenerateTicketResponseDTO();
        try{
            Ticket ticket = ticketService.generateTicket(requestDTO.getGateId(), requestDTO.getVehicleNumber(),
                    requestDTO.getVehicleType());
            responseDTO.setGenerateTicketID(ticket.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Ticket generated successfully");
        } catch (Exception ex){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(ex.getMessage());
        }
        return responseDTO;
    }
}
