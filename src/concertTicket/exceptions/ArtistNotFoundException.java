
package concertTicket.exceptions;

import java.util.List;

/**
 *
 * @author Joao Monteiro
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
        if(artistList==null){
            r = new String[artistList.size()];
            artistList.toArray(r);
        }else {
            r = new String[1];
            r[0] = artist;
        }
        return r;
    }
}
