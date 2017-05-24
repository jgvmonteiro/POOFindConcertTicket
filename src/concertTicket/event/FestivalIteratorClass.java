package concertTicket.event;

import concertTicket.artist.Artist;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Joao Monteiro
 */
public class FestivalIteratorClass implements FestivalDataIterator{

    Iterator<LocalDate> dates;
    Iterator<Artist[]> artists;
    Artist[] artistArray;
    int artist_index;
    
    
    public FestivalIteratorClass(Map<LocalDate, Artist[]> alignment) {
        this.dates = alignment.keySet().iterator();
        this.artists = alignment.values().iterator();
    }

    @Override
    public boolean hasNextDate() {
        return dates.hasNext();
    }

    @Override
    public LocalDate nextDate() {
        artist_index=0;
        artistArray = artists.next();//Always exists some artist for each day...
        return dates.next();
    }

    @Override
    public boolean hasNextArtist() {
        return (artist_index<artistArray.length);
    }

    @Override
    public Artist nextArtist() {
        return artistArray[artist_index++];
    }

}
