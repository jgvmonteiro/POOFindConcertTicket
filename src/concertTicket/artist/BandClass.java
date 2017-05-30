
package concertTicket.artist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class implements Band interface
 * Extends ArtistClass 
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
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
