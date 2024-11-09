import controllers.TicketController;
import dtos.GenerateTicketRequestDTO;
import dtos.GenerateTicketResponseDTO;
import dtos.ResponseStatus;
import models.enums.VehicleType;
import repositories.*;
import services.GateService;
import services.TicketService;
import services.VehicleService;
import services.strategies.BoothAllocationStrategy;
import services.strategies.FirstEmptyBoothStrategy;

public class Client {
    public static void main(String[] args) {
        TicketRepository tr = new TicketRepository();
        GateRepository gr = new GateRepository();
        VehicleRepository vr = new VehicleRepository();
        ParkingLotRepository pr = new ParkingLotRepository();
        BoothRepository br = new BoothRepository();

        VehicleService vs = new VehicleService(vr);
        GateService gs = new GateService(gr);

        BoothAllocationStrategy boothAllocationStrategy = new FirstEmptyBoothStrategy(pr, br);

        TicketService ts = new TicketService(tr, gs, vs, boothAllocationStrategy);
        TicketController ticketController = new TicketController(ts);

        GenerateTicketRequestDTO ticketRequestDTO = new GenerateTicketRequestDTO();
        ticketRequestDTO.setVehicleType(VehicleType.MEDIUM);
        ticketRequestDTO.setVehicleNumber("TR0208");
        ticketRequestDTO.setGateId(10L);

        GenerateTicketResponseDTO ticketResponseDTO = ticketController.generateTicket(ticketRequestDTO);

        if(ticketResponseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(ticketResponseDTO.getMessage());
        }
        else{
            System.out.println("Ticket generated with id: " + ticketResponseDTO.getGenerateTicketID());
        }
    }
}

