
package concertTicket.users;

import concertTicket.event.Event;
import concertTicket.ticket.Ticket;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Client extends User{

    void addTicket(Ticket event);
    Iterator<Ticket> ticketsIterator();
    
}
