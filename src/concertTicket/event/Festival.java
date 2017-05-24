
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.ticket.FestivalTicket;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface Festival extends Event{

    int price(int days);
    FestivalTicket buyTicket(LocalDate[] dates);
    int checkTicketOnDate(LocalDate date);
}
