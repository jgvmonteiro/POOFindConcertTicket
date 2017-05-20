
package concertTicker.artist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class BandClass extends ArtistClass implements Band{

    private List<String> crew;
    
    public BandClass(String name, String[] albuns, String[] crew) {
        super(name, albuns);
        this.crew = createCrewList(crew);
    }

    @Override
    public Iterator<String> artistsNames() {
       return crew.iterator();
    }
    
    private List<String> createCrewList(String[] crew) {
    	List<String> crewList = new ArrayList<String>();
    	for(int i = 0; i < crew.length; i++){
    		crewList.add(crew[i]);
    	}
    	return crewList;
    }
    

}
