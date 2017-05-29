package concertTicket.event;

import concertTicket.artist.Artist;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface FestivalDataIterator {

    boolean hasNextDate();
    LocalDate nextDate();
    boolean hasNextArtist();
    Artist nextArtist();
    
}
