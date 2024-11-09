package dtos;

public class GenerateTicketResponseDTO {
    private Long generateTicketID;
    private String message;
    private ResponseStatus responseStatus;

    public Long getGenerateTicketID() {
        return generateTicketID;
    }

    public void setGenerateTicketID(Long generateTicketID) {
        this.generateTicketID = generateTicketID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
