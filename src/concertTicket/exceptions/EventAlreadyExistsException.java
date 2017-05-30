
package concertTicket.exceptions;

/**
 * Thrown when an admin attempts to add an Event into the database but the date and name are the same as one which already
 * exists.
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class EventAlreadyExistsException extends Exception{

    public EventAlreadyExistsException() {
        super();
    }

    
}
