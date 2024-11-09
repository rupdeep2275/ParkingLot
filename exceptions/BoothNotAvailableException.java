package exceptions;

public class BoothNotAvailableException extends Exception{
    public BoothNotAvailableException(){
        super("No parking booth available");
    }
}
