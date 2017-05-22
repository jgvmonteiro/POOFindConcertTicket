
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class LogoutException extends Exception{
    
    private static final String DEFAULT_MESSAGE = "No user is logged in.\n";

    public LogoutException() {
        super(DEFAULT_MESSAGE);
    }

    public LogoutException(String message) {
        super(message);
    }
    
    
    
}
