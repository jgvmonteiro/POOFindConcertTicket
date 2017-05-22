
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class UserNotFoundException extends Exception{
    
    private static final String DEFAULT_MESSAGE = "User does not exist.";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
    
    
}
