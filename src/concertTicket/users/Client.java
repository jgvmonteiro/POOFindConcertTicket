
package concertTicket.users;

import concertTicket.event.Event;
import java.util.Iterator;

/**
 *
 * @author Joao Monteiro
 */
public interface Client extends User{

    void addEvent(Event event);
    Iterator<Event> myEventsIterator();
    
}
