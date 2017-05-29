
package concertTicket.artist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class BandClass extends ArtistClass implements Band{

    private List<String> elements;
    
    public BandClass(String name, String[] albuns, String[] elements) {
        super(name, albuns);
        this.elements = new ArrayList<String>();
        for(String member:elements)
            this.elements.add(member);
    }

    @Override
    public Iterator<String> artistsNames() {
       return elements.iterator();
    }
    

}
