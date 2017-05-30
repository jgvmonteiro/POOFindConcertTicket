
package concertTicket.exceptions;

/**
 * Thrown when a Client attempts to buy a ticket for a non-existing event (date and name aren't in the database) or
 * when a User attempts to search the info of a non-existing event.
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class EventNotFoundException extends Exception{

    public EventNotFoundException() {
        super();
    }

    
}
