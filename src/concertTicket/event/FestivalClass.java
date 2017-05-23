
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.ticket.FestivalTicket;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author Joao Monteiro
 */
public class FestivalClass extends EventClass implements Festival{

    private Map<LocalDate,Artist[]> alignemnt;
    private int duration, availableTickets;
    private int[] prices;  
    private LocalDate startDate;
    
    public FestivalClass(String name, String description, Map<LocalDate,Artist[]> alignment, LocalDate startDate, int duration, int avaiableTickets, int[] prices) {
        super(name, description);
        this.duration = duration;
        this.prices = prices;
        this.startDate = startDate;
        this.availableTickets = avaiableTickets;
    }

    

    @Override
    public LocalDate startDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int price(int[] days) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int avaiableTickets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FestivalTicket buyTicket(String[] dates) {
        
        
        return null;
    }
    
    

    @Override
    public boolean equals(Event event) {
        if(event instanceof Festival){
            Festival fest = (Festival)event;
            if(fest.name().equalsIgnoreCase(name()) && fest.startDate().isEqual(startDate))
                return true;
       }
        return false;
    }

    
    
    
    
}
