package concertTicket.comparator;

import concertTicket.ticket.ConcertTicket;
import concertTicket.ticket.FestivalTicket;
import concertTicket.ticket.Ticket;
import java.util.Comparator;

/**
 * Custom comparator
 * Sorts a list of Event(s), Concert tickets first and Festival tickets next
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class TicketTypeComparator implements Comparator<Ticket>{

    @Override
    public int compare(Ticket o1, Ticket o2) {
        if(o1 instanceof ConcertTicket && o2 instanceof FestivalTicket)
            return -1;
        else if(o1 instanceof FestivalTicket && o2 instanceof ConcertTicket)
            return 1;
        else
            return 0;
    }

}
