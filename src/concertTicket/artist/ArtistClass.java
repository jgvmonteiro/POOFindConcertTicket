
package concertTicket.artist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class ArtistClass implements Artist{
    
    private String name;
    private List<String> albums;

    public ArtistClass(String name, String[] albums) {
        this.name = name;
        this.albums = createList(albums);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterator<String> getAlbums() {
        return albums.iterator();
    }
    
    private List<String> createList(String[] albums) {
    	List<String> albumList = new ArrayList<String>();
    	for(int i = 0; i < albums.length; i++){
    		albumList.add(albums[i]);
    	}
    	return albumList;
    }
    
    
    
    
}
