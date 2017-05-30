
package concertTicket.ticket;

import java.time.LocalDate;

/**
 * ConcertTicket is a subclass of Ticket. Since you can buy more than one at a time, it stores the amount of tickets
 * sold in that time (numberTickets) and the date for which it was bought (startDate). 
 * The total price becomes numberTickets * ticketPrice
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface ConcertTicket extends Ticket{

	/**
	 * Get method for the date for which this specific concert ticket was bought
	 * @return LocalDate date, a parameter given in the ConcertTicket constructor which cannot be altered in a ConcertTicket 
	 * instance
	 */
    LocalDate startDate();
    
    /**
     * Get method for the int numberTickets sold in this specific purchase.
     * @return numberTickets, a parameter given in the ConcertTicket constructor which cannot be altered in a ConcertTicket 
     * instance
     */
    int numberTickets();
}
