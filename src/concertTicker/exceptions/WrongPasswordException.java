
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class WrongPasswordException extends Exception{

    private static final String DEFAULT_MESSAGE = "Wrong password.\n";

    public WrongPasswordException() {
        super(DEFAULT_MESSAGE);
    }

    public WrongPasswordException(String message) {
        super(message);
    }
    
    
    
}
