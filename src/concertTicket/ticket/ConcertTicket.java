
package concertTicket.ticket;

import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface ConcertTicket extends Ticket{

    LocalDate startDate();
    int numberTickets();
}
