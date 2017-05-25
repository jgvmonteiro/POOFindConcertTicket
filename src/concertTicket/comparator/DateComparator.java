package concertTicket.comparator;

import concertTicket.event.Event;
import java.util.Comparator;

/**
 *
 * @author Joao Monteiro
 */
public class DateComparator implements Comparator<Event>{

    @Override
    public int compare(Event o1, Event o2) {
        return o1.startDate().compareTo(o2.startDate());
    }

}
