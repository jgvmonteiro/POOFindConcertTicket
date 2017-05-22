
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class EventSoldOutException extends Exception{

    private static final String DEFAULT_MESSAGE = "There are not sufficient seats for the request";

    public EventSoldOutException() {
        super(DEFAULT_MESSAGE);
    }

    public EventSoldOutException(String message) {
        super(message);
    }
    
    
    
}
