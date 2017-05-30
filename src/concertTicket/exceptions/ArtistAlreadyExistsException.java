
package concertTicket.exceptions;

/**
 * Thrown when an admin is attempting to add an artist into the database but its name is the same as another artist's name
 * that is stored in the artist/ band database
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class ArtistAlreadyExistsException extends Exception{

    public ArtistAlreadyExistsException() {
        super();
    }

    
    

}
