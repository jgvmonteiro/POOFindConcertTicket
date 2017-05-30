
package concertTicket.exceptions;

import java.util.List;

/**
 * Thrown when an admin attempts to create a concert but uses a non existing artist (artistList = null);
 * Thrown when an admin attempts to create a festival but uses one or more non existing artists (artistList = list of non existing artists);
 * Thrown when a user attempts to search an artist's information of someone who isn't in the database
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class ArtistNotFoundException extends Exception{

	List<String> artistList;
        private String artist;
	
    public ArtistNotFoundException() {
        super();
    }
    
    public ArtistNotFoundException(String artist) {
        super();
        this.artist = artist;
    }

    public ArtistNotFoundException(List<String> artistList){
    	super();
    	this.artistList = artistList;
    }
    
    public String[] getArtistList(){
        String[] r;
        if(artistList!=null){
            r = new String[artistList.size()];
            artistList.toArray(r);
        }else {
            r = new String[1];
            r[0] = artist;
        }
        return r;
    }
}
