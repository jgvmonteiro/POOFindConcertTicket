
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class UserAlreadyLoggedInException extends Exception{
    
    private static final String DEAFULT_MESSAGE = "Another user is logged in.";

    public UserAlreadyLoggedInException() {
        super(DEAFULT_MESSAGE);
    }

    public UserAlreadyLoggedInException(String message) {
        super(message);
    }
    
    

            
}
