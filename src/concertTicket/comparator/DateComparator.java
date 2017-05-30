package concertTicket.comparator;

import concertTicket.event.Event;
import java.util.Comparator;

/**
 * Custom comparator
 * Sorts a list of Event(s) from oldest date to newer date
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class DateComparator implements Comparator<Event>{

    @Override
    public int compare(Event o1, Event o2) {
        return o1.startDate().compareTo(o2.startDate());
    }

}
