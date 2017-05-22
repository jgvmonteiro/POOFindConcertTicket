
package concertTicker.ticket;

import concertTicker.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public interface Ticket {

    Event event();
    String getBarCode();
    
    
    
}
