
package concertTicket.ticket;

import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class ConcertTicketClass extends TicketClass implements ConcertTicket{

    int numTickets;
    LocalDate date;

    /**
     * 
     * @param eventName event's name
     * @param date event's date
     * @param ammount number of persons the ticket can give access to the event
     * @param price price per person
     */
    public ConcertTicketClass(String eventName,LocalDate date, int ammount, int price) {
        super(eventName, ammount*price);
        this.numTickets = ammount;
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
