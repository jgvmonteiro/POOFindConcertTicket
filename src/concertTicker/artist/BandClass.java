
package concertTicker.artist;

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
        this.elements = createList(elements);
    }

    @Override
    public Iterator<String> artistsNames() {
       return elements.iterator();
    }
    
    private List<String> createList(String[] crew) {
    	List<String> crewList = new ArrayList<String>();
    	for(int i = 0; i < crew.length; i++){
    		crewList.add(crew[i]);
    	}
    	return crewList;
    }
    

}
