
package concertTicket.exceptions;

/**
 * Thrown when a user attempts to log in but inputs the wrong password (His email is related to a different 
 * password in the database)
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class WrongPasswordException extends Exception{

    public WrongPasswordException() {
        super();
    }

    
    
    
}
