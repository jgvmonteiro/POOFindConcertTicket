
package concertTicket.users;

import concertTicket.ticket.Ticket;
import java.util.Iterator;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Client extends User{

    void addTicket(Ticket event);
    Iterator<Ticket> ticketsIterator();
    
}
