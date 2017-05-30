
package concertTicket.users;

import concertTicket.ticket.Ticket;
import java.util.Iterator;

/**
 * Client, being a subclass of User, have access to all the information about shows, etc and everything to
 * do with tickets: purchasing and listing.
 * Each client object has an orderedList of tickets associated with it.
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Client extends User{

	/**
	 * Adds a ticket 'event' into the OrderedList myTickets
	 * @param event, event to be added into the OrderedList
	 */
    void addTicket(Ticket event);
    
    /**
     * Used to iterate a User's tickets
     * @return myTickets iterator, ordered by insertion time
     */
    Iterator<Ticket> ticketsIterator();
    
}
