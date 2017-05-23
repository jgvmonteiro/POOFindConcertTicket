
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.ticket.ConcertTicket;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface Concert extends Event{

    Artist artist();
    LocalDate date();
    String description();
    int availableTickets();
    ConcertTicket buyTickets(int amount);
    int price();
    
    
    
}
