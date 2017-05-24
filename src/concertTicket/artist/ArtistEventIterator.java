package concertTicket.artist;

import concertTicket.event.Concert;
import concertTicket.event.Festival;

/**
 *
 * @author Joao Monteiro
 */
public interface ArtistEventIterator {

    boolean hasNextConcert();
    Concert nextConcert();
    boolean hasNextFestival();
    Festival nextFestival();
    
}
