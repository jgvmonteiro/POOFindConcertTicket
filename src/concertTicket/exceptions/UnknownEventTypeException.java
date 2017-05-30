package concertTicket.exceptions;

/**
 * Thrown when a user attempts to listEventsByType but the type input is neither concert nor festival
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class UnknownEventTypeException extends Exception {

    public UnknownEventTypeException() {
        super();
    }

}
