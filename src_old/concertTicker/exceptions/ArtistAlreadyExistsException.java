
package concertTicker.exceptions;

/**
 *
 * @author Joao Monteiro
 */
public class ArtistAlreadyExistsException extends Exception{
    
    private static final String DEFAULT_MESSAGE = "Artist name already exists.";

    public ArtistAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public ArtistAlreadyExistsException(String message) {
        super(message);
    }
    
    

}
