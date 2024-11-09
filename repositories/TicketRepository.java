package repositories;

import models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    private HashMap<Long, Ticket> ticketTable = new HashMap<>();
    private Long autoIncrementId = 0L;
    public Ticket save(Ticket ticket){
        if(ticket.getId() == null){
            //insert
            autoIncrementId++;
            ticketTable.put(autoIncrementId, ticket);
            ticket.setId(autoIncrementId);
        }
        else{
            ticketTable.put(ticket.getId(), ticket);
        }
        return ticket;
    }
}
