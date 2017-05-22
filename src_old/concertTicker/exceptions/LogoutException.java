
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class LogoutException extends Exception{
    
    private static final String DEFAULT_MESSAGE = "No user logged in.";

    public LogoutException() {
        super(DEFAULT_MESSAGE);
    }

    public LogoutException(String message) {
        super(message);
    }
    
    
    
}
