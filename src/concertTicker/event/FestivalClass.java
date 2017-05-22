
package concertTicker.event;

import concertTicker.artist.Artist;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public class FestivalClass extends EventClass implements Festival{

    private Artist[] artists;
    private int duration;
    private int price;
    
    private String startDate;
    private String endDate;
    
    
    public FestivalClass(String name, String description, Artist[] artists, LocalDate startDate, int days, int avaiableTickets[], int price) {
        super(name, description);
        
    }

    
    @Override
    public Artist[] artist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String startDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String endDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  

    @Override
    public int price(int[] days) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int avaiableTickets(String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buyTicket(String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public boolean equals(Event event) {
        if(event instanceof Festival){
            Festival fest = (Festival)event;
            if(fest.getEventName().equalsIgnoreCase(getEventName()) && fest.startDate().equalsIgnoreCase(startDate))
                return true;
       }
        return false;
    }

    
    
    
    
}
