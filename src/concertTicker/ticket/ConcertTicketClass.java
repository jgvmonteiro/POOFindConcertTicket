
package concertTicker.ticket;

import concertTicker.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public class ConcertTicketClass extends TicketClass implements ConcertTicket{

    int spectators;

    public ConcertTicketClass(Event event,int spectators) {
        super(event);
        this.spectators = spectators;
    }

    @Override
    public int spectators() {
        return spectators;
    }
    
    
    
    
    
    
    
}
