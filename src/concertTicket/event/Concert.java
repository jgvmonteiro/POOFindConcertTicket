
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.exceptions.EventSoldOutException;
import concertTicket.ticket.ConcertTicket;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface Concert extends Event{

    Artist artist();
    String description();
    ConcertTicket buyTickets(int amount) throws EventSoldOutException;
    int price();
    int availableTickets();
    
    
}
