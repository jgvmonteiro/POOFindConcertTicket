package concertTicker.exceptions;

public class UnknownEventTypeException extends Exception{
	
    private static final String DEFAULT_MESSAGE = "Unknown type of show.";

	public UnknownEventTypeException(){
		super(DEFAULT_MESSAGE);
	}
	
	public UnknownEventTypeException(String message){
		super(message);
	}
}
