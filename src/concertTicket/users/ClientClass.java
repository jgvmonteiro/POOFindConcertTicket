
package concertTicket.users;

import concertTicket.util.OrderList;
import concertTicket.util.OrderListClass;
import concertTicket.event.Event;
import concertTicket.ticket.Ticket;
import concertTicket.comparator.TicketTypeComparator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class ClientClass extends UserClass implements Client{

    OrderList<Ticket> myTickets;
    
    public ClientClass(String email, String password) {
        super(email, password);
        myTickets = new OrderListClass<Ticket>(new TicketTypeComparator(), true);
    }

    @Override
    public void addTicket(Ticket event) {
        myTickets.add(event);
    }

    @Override
    public Iterator<Ticket> ticketsIterator() {
        return myTickets.iterator();
    }

    
    
    
    
}
