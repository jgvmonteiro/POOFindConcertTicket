package concertTicket.comparator;

import concertTicket.event.Event;
import java.util.Comparator;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class MostSoldComparator implements Comparator<Event> {
    
    @Override
    public int compare(Event o1, Event o2) {
        if (o1.soldTickets() == o2.soldTickets()) {
            if (o1.startDate().isBefore(o2.startDate())) {
                return -1;
            } else if (o1.startDate().isEqual(o2.startDate())) {
                return o1.name().compareTo(o2.name());
            } else {
                return 1;
            }
        } else if (o1.soldTickets() > o2.soldTickets()) {
            return -1;
        } else {
            return 1;
        }
    }


}
