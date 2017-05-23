
package concertTicket.ticket;

import concertTicket.event.Event;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public class ConcertTicketClass extends TicketClass implements ConcertTicket{

    int numTickets;
    LocalDate date;

    public ConcertTicketClass(String eventName,LocalDate date, int numTickets, int price) {
        super(eventName, numTickets*price);
        this.numTickets = numTickets;
        this.date = date;
    }

    @Override
    public LocalDate startDate() {
        return  date;
    }

    
    
    @Override
    public int numberTickets() {
        return numTickets;
    }

    
    
    
    
    
    
}
