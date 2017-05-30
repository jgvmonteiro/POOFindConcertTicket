
package concertTicket.exceptions;

/**
 * Thrown when a user attempts to call a function in the application but their account doesn't have enough privileges
 * to do so. (see: User, Client, Admin)
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class InvalidPrivilegeException extends Exception{

    public InvalidPrivilegeException() {
        super();
    }

    
    
}
