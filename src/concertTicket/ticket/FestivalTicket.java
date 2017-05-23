
package concertTicket.ticket;

import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface FestivalTicket extends Ticket{

    LocalDate[] dates();
    
}
