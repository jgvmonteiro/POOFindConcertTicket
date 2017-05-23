
package concertTicket.users;

import concertTicket.event.Event;
import concertTicket.ticket.Ticket;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public interface Client extends User{

    void addTicket(Ticket event);
    List<Ticket> myTickets();
    
}
