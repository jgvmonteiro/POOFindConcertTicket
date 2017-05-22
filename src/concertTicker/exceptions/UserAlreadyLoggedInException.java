
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class UserAlreadyLoggedInException extends Exception{
    
    private static final String DEFAULT_MESSAGE = "User already logged in.\n";

    public UserAlreadyLoggedInException() {
        super(DEFAULT_MESSAGE);
    }

    public UserAlreadyLoggedInException(String message) {
        super(message);
    }
    
    

            
}
