package concertTicket.event;

import concertTicket.artist.Artist;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

/**
 *  This class implements FestivalDataIterator
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class FestivaDatalIteratorClass implements FestivalDataIterator{

    Iterator<LocalDate> dates;
    Iterator<Artist[]> artists;
    Artist[] artistArray;
    int artist_index;
    
    /**
     * 
     * @param alignment map containing the artist to perform in the festival for each date
     */
    public FestivaDatalIteratorClass(Map<LocalDate, Artist[]> alignment) {
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
