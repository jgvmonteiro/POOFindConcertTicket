
package concertTicket.artist;

import java.util.Iterator;

/**
 * Artist interface
 * Represent an artist with a name and a collection of albums
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Artist {

    /**
     * 
     * @return artist name
     */
    String getName();
    
    /**
     * 
     * @return iterator containing all albums of this artist
     */
    Iterator<String> getAlbums();
    
    
}
