
package concertTicket.ticket;

import concertTicket.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public abstract class TicketClass implements Ticket{
    
    String eventName;
    String code; ////??????????
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
    public String getBarCode() {
        return code;
    }

    @Override
    public int totalPrice() {
        return 0;
    }
    
    

    
    
    
}
