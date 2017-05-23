
package concertTicket.ticket;

import concertTicket.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public abstract class TicketClass implements Ticket{
    
    String eventName;
    int totalPrice;
    
    public TicketClass(String eventName, int totalPrice) {
        this.eventName = eventName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String eventName() {
        return eventName;
    }


    @Override
    public int totalPrice() {
        return totalPrice;
    }
    
    
    public int compareTo(Ticket t){
    	return 0;
    }

    
    
    
}
