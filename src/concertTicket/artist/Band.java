
package concertTicket.artist;

import java.util.Iterator;

/**
 * Band interface
 * Extends an artist with a name and a collection of albums
 * Adds a new collection with the band elements names
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Band extends Artist{
    
    /**
     * 
     * @return iterator with all band elements names
     */
    Iterator<String> artistsNames();

}
