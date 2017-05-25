
package concertTicket.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class ArtistNotFoundException extends Exception{

	String artistList[];
	
    public ArtistNotFoundException() {
        super();
    }
    
    public ArtistNotFoundException(String artist) {
        super();
        artistList = new String[1];
        artistList[0] = artist;
    }

    public ArtistNotFoundException(String artistList[]){
    	super();
    	this.artistList = artistList;
    }
    
    public String[] getArtistList(){
    	return this.artistList;
    }
}
