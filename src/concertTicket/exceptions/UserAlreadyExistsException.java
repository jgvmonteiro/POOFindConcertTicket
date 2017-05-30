
package concertTicket.exceptions;

/**
 * Thrown when a user attempts to register into the applcation but someone with that email has already made an account.
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class UserAlreadyExistsException extends Exception{

    public UserAlreadyExistsException() {
        super();
    }

    
    
}
