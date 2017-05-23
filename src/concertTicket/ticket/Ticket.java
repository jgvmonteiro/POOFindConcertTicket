
package concertTicket.ticket;

import concertTicket.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public interface Ticket {

    String eventName();
    String getBarCode();
    int totalPrice();
    
    
    
}
