
package concertTicket.ticket;

import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface FestivalTicket extends Ticket{

    LocalDate[] dates();
    
}
