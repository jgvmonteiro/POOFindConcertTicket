package concertTicket;

import concertTicket.event.Event;
import java.util.Comparator;

/**
 *
 * @author Joao Monteiro
 */
public class MostSoldOrder implements Comparator<Event>{

    @Override
    public int compare(Event o1, Event o2) {
        if(o1.soldTickets() == o2.soldTickets()){
            if(o2.startDate().isBefore(o1.startDate()))
                return 1;
            else if(o2.startDate().equals(o1.startDate()))
                return o2.name().compareTo(o1.name());
            else 
                return 1; 
        }    
        else 
            return (o2.soldTickets()-o1.soldTickets());
    }

}
