
package concertTicket.exceptions;

/**
 * Thrown when an user is trying to call 'login' and FindConcertTicket's current user isn't null
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class AnotherUserLoggedInException extends Exception{

    public AnotherUserLoggedInException() {
        super();
    }
    
    
}
