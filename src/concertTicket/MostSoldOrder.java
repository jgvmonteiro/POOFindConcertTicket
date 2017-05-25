package concertTicket;

import concertTicket.event.Event;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class MostSoldOrder implements Comparator<Event> {

    @Override
    public int compare(Event o1, Event o2) {
        LocalDate today = LocalDate.now();
        if (o1.soldTickets() == o2.soldTickets()) {
            if (Math.abs(o1.startDate().toEpochDay() - today.toEpochDay()) - Math.abs(o2.startDate().toEpochDay() - today.toEpochDay()) < 0) {
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
