
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class UserAlreadyExistsException extends Exception{

    private static final String DEFAULT_MESSAGE = "User already exists.";

    public UserAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
    
    
    
}
