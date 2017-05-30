
package concertTicket.artist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class ArtistClass implements Artist{
    
    private String name;
    private List<String> albums;

    public ArtistClass(String name, String[] albums) {
        this.name = name;
        for(String album : albums)
            this.albums.add(album);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterator<String> getAlbums() {
        return albums.iterator();
    }
    
}
