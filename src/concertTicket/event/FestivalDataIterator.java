package concertTicket.event;

import concertTicket.artist.Artist;
import java.time.LocalDate;
import java.util.Iterator;

/**
 *
 * @author Joao Monteiro
 */
public interface FestivalDataIterator {

    boolean hasNextDate();
    LocalDate nextDate();
    boolean hasNextArtist();
    Artist nextArtist();
    
}
