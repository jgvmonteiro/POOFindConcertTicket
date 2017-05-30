package concertTicket.artist;

import concertTicket.event.Concert;
import concertTicket.event.Festival;

/**
 * Custom iterator
 * Used to list all artist events, concert and festivals individually
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface ArtistEventIterator {

    /**
     * 
     * @return true if has next concert in the collection
     */
    boolean hasNextConcert();
   
    /**
     * 
     * @return next concert
     */
    Concert nextConcert();
    
    /**
     * 
     * @return true if has next festival in the collection
     */
    boolean hasNextFestival();
    
    /**
     * 
     * @return next festival
     */
    Festival nextFestival();
    
}
