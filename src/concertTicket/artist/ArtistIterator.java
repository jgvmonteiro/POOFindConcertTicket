package concertTicket.artist;

import concertTicket.event.Concert;
import concertTicket.event.Event;
import concertTicket.event.Festival;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joao Monteiro
 */
public class ArtistIterator implements ArtistEventIterator{

    Iterator<Event> concerts;
    Iterator<Event> festivals;
    
    public ArtistIterator(Map<String, List<Event>> eventsMap) {
        concerts = eventsMap.get(concertTicket.FindConcertTicket.EVENT_TYPE_CONCERT).iterator();
        festivals = eventsMap.get(concertTicket.FindConcertTicket.EVENT_TYPE_FESTIVAL).iterator();
    }
    
    @Override
    public boolean hasNextConcert() {
       return concerts.hasNext();
    }

    @Override
    public Concert nextConcert() {
        return (Concert)concerts.next();
    }

    @Override
    public boolean hasNextFestival() {
       return festivals.hasNext();
    }

    @Override
    public Festival nextFestival() {
        return (Festival)festivals.next();
    }

}
