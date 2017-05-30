
package concertTicket.ticket;


/**
 * Ticket is the superclass of ConcertTicket and FestivalTicket. Clients can add these into the 'myTickets' orderList.
 * The superclass stores the total cost and the name of the event which they were purchased for.
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Ticket extends Comparable<Ticket> {

	/**
	 * Get method for eventName
	 * @return eventName, a parameter in the TicketClass constructor
	 */
    String eventName();
    
    /**
     * Get method for totalPrice
     * @return totalPrice, the sum of money spent on said ticket(s)
     */
    int totalPrice();
    
    
    
}
