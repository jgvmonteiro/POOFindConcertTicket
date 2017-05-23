
package concertTicket.ticket;

import concertTicket.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public interface Ticket extends Comparable<Ticket> {

    String eventName();
    int totalPrice();
    
    
    
}
