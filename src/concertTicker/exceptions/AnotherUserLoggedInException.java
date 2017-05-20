
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class AnotherUserLoggedInException extends Exception{

    private static final String DEFAULT_MESSAGE = "Another user is logged in.";

    public AnotherUserLoggedInException() {
        super(DEFAULT_MESSAGE);
    }

    public AnotherUserLoggedInException(String message) {
        super(message);
    }
            
    
            
    
}
