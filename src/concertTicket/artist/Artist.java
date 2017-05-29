
package concertTicket.artist;

import java.util.Iterator;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Artist {

	/**
	 * Get method for the artist's name
	 * @return the artist's name given when the object is created
	 */
    String getName();
    
    /**
     * To return a list of the artist's albums
     * @return List of album titles (Strings), given when the object is created
     */
    Iterator<String> getAlbums();
    
    
}
