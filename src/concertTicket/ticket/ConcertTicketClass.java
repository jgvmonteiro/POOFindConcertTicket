
package concertTicket.ticket;

import concertTicket.event.Event;

/**
 *
 * @author Joao Monteiro
 */
public class ConcertTicketClass extends TicketClass implements ConcertTicket{

    int numTickets;

    public ConcertTicketClass(String eventName,int numTickets, int price) {
        super(eventName, numTickets*price);
        this.numTickets = numTickets;
    }

    @Override
    public int numberTickets() {
        return numTickets;
    }

    
    
    
    
    
    
}
