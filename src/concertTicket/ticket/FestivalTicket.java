
package concertTicket.ticket;

import java.time.LocalDate;

/**
 * FestivalTicket is a subclass of Ticket and stores the array of dates for which it was bought.
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface FestivalTicket extends Ticket{

	/**
	 * Get method for the array of dates for which this specific instance of FestivalTicket was bought
	 * @return dates, an array containing objects of the LocalDate type which refer to the dates for 
	 * which this instance of FestivalTicket was bought
	 */
    LocalDate[] dates();
    
}
