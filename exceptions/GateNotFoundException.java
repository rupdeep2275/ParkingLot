package exceptions;

public class GateNotFoundException extends Exception{
    public GateNotFoundException(){
        super("Gate with given id is not present");
    }
}
