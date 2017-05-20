
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class InvalidPrivilegeException extends Exception{

    private static final String DEFAULT_MESSAGE = "User cannot execute this command";

    public InvalidPrivilegeException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidPrivilegeException(String message) {
        super(message);
    }
    
    
}
