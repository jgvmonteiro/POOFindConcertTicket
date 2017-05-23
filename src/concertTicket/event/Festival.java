
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.ticket.FestivalTicket;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface Festival extends Event{

    LocalDate startDate();
    int price(int days);
    int avaiableTickets();
    FestivalTicket buyTicket(String[] dates);
    
}
