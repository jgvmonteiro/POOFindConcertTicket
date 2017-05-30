
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.exceptions.EventSoldOutException;
import concertTicket.ticket.ConcertTicket;

/**
 * Represents concert with an artist to perform
 * Contains informations about the concert
 * Allows to buy tickets for the concert
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Concert extends Event{

    /**
     * 
     * @return Artist performing in this concert
     */
    Artist artist();      
    
    /**
     * Buys a tickets for the this concert
     * @param amount number people with access to the event with this ticket
     * @return Ticket the bought ticket
     * @throws EventSoldOutException amount is grater than the number of people this event has available
     */
    ConcertTicket buyTickets(int amount) throws EventSoldOutException;
    
    /**
     * 
     * @return price per person of this event 
     */
    int price();
    
    /**
     * 
     * @return number of available tickets for the event 
     */
    int availableTickets();
    
    
}
