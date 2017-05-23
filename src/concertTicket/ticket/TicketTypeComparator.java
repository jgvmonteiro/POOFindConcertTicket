package concertTicket.ticket;

import java.util.Comparator;

/**
 *
 * @author Joao Monteiro
 */
public class TicketTypeComparator implements Comparator<Ticket>{

    @Override
    public int compare(Ticket o1, Ticket o2) {
        if(o1 instanceof ConcertTicket && o2 instanceof FestivalTicket)
            return 1;
        else if(o1 instanceof FestivalTicket && o2 instanceof ConcertTicket)
            return -1;
        else
            return 0;
    }

}
