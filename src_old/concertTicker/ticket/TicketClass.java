
package concertTicker.ticket;

import concertTicker.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public abstract class TicketClass implements Ticket{
    
    Event event;
    String code; ////??????????
    
    public TicketClass(Event event) {
        this.event = event;
        this.code = code;
    }

    @Override
    public Event event() {
        return event;
    }

    @Override
    public String getBarCode() {
        return code;
    }

    
    
    
}
