
package concertTicket.users;

import concertTicket.event.Event;
import concertTicket.ticket.Ticket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class ClientClass extends UserClass implements Client{

    List<Ticket> myTickets;
    
    public ClientClass(String email, String password) {
        super(email, password);
        myTickets = new ArrayList();
    }

    @Override
    public void addTicket(Ticket event) {
        myTickets.add(event);
    }

    @Override
    public List<Ticket> myTickets() {
        return myTickets;
    }

    
    
    
    
}
