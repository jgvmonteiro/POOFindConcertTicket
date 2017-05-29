package concertTicket.artist;

import concertTicket.event.Concert;
import concertTicket.event.Festival;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface ArtistEventIterator {

	/**
	 * Returns true if concertIterator.hasNext()
	 * @return true if there are more concerts to iterate
	 */
    boolean hasNextConcert();
    
    /**
     * Returns the next concert in the iterator by calling concertIterator.next()
     * @return the next concert in the iterator
     */
    Concert nextConcert();
    
    /**
	 * Returns true if festivalIterator.hasNext()
	 * @return true if there are more festivals to iterate
	 */
    boolean hasNextFestival();
    
    /**
     * Returns the next festival in the iterator by calling festivalIterator.next()
     * @return the next festival in the iterator
     */
    Festival nextFestival();
    
}
