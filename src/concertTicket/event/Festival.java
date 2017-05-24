
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.exceptions.EventSoldOutException;
import concertTicket.ticket.FestivalTicket;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface Festival extends Event{

    int price(int days);
    int duration();
    FestivalTicket buyTicket(LocalDate[] dates) throws EventSoldOutException;
    int availableTickets(LocalDate date);
    FestivalDataIterator alignmentIterator();
}
