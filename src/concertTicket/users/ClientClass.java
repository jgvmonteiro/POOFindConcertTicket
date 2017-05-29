
package concertTicket.users;

import concertTicket.util.OrderList;
import concertTicket.util.OrderListClass;
import concertTicket.ticket.Ticket;
import concertTicket.comparator.TicketTypeComparator;
import java.util.Iterator;

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
