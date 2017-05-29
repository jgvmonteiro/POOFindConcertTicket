
package concertTicket.ticket;

import concertTicket.event.Event;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Ticket extends Comparable<Ticket> {

    String eventName();
    int totalPrice();
    
    
    
}
