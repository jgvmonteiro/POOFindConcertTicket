package concertTicket.artist;

import concertTicket.FindConcertTicket;
import concertTicket.util.OrderList;
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
public class ArtistEventIteratorClass implements ArtistEventIterator{

    Iterator<Event> concerts;
    Iterator<Event> festivals;
    
    public ArtistEventIteratorClass(Map<FindConcertTicket.EVENT_TYPE, OrderList<Event>> eventsMap) {
        concerts = eventsMap.get(concertTicket.FindConcertTicket.EVENT_TYPE.CONCERT).iterator();
        festivals = eventsMap.get(concertTicket.FindConcertTicket.EVENT_TYPE.FESTIVAL).iterator();
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
