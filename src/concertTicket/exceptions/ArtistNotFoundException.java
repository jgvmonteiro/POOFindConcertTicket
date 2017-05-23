
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

    public ArtistNotFoundException(String artistList[]){
    	this.artistList = artistList;
    }
    
    public String[] getArtistList(){
    	return this.artistList;
    }
}
