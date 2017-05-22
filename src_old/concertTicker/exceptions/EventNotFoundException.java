
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class EventNotFoundException extends Exception{

    private static final String DEFAULT_MESSAGE = "Show does not exists.";

    public EventNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public EventNotFoundException(String message) {
        super(message);
    }

    
    
    
}
