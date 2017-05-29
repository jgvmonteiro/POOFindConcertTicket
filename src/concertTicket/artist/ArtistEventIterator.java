package concertTicket.artist;

import concertTicket.event.Concert;
import concertTicket.event.Festival;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface ArtistEventIterator {

    boolean hasNextConcert();
    Concert nextConcert();
    boolean hasNextFestival();
    Festival nextFestival();
    
}
