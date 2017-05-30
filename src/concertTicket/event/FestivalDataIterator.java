package concertTicket.event;

import concertTicket.artist.Artist;
import java.time.LocalDate;

/**
 * custom iterator
 * Allows to iterator through an festival alignment (dates and the artists in the given date)
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface FestivalDataIterator {

    /**
     * 
     * @return true if festival has a next date
     */
    boolean hasNextDate();
    
    /**
     * Selects the artists for the next date
     * @return the next date
     */
    LocalDate nextDate();
    
    /**
     * 
     * @return true if next artist exists in the current date
     */
    boolean hasNextArtist();
    
    /**
     * 
     * @return next artist of the current date
     */
    Artist nextArtist();
    
}
