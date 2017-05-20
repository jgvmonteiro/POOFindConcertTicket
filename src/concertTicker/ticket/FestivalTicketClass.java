
package concertTicker.ticket;

import concertTicker.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public class FestivalTicketClass extends TicketClass implements FestivalTicket{

    int[] days;
    
    public FestivalTicketClass(Event event, int[] days) {
        super(event);
        this.days = days;
    }

    @Override
    public int[] days() {
        return days;
    }

    
    
}
