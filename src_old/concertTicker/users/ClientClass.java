
package concertTicker.users;

import concertTicker.event.Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class ClientClass extends UserClass implements Client{

    List<Event> myEvents;
    
    public ClientClass(String email, String password) {
        super(email, password);
        myEvents = new ArrayList();
    }

    @Override
    public void addEvent(Event event) {
        myEvents.add(event);
    }

    @Override
    public Iterator<Event> myEventsIterator() {
        return myEvents.iterator();
    }

    
    
    
    
}
