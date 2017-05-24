
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.ticket.FestivalTicket;
import concertTicket.ticket.FestivalTicketClass;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joao Monteiro
 */
public class FestivalClass extends EventClass implements Festival{

    private Map<LocalDate,Artist[]> alignemnt;
    private int duration;
    private int[] prices;
    private Map<LocalDate, Integer> avTicketsFest;
    private LocalDate startDate;
    
    public FestivalClass(String name, String description, Map<LocalDate,Artist[]> alignment, LocalDate startDate, int duration, int availableTickets, int[] prices) {
        super(name, description, availableTickets);
        this.duration = duration;
        this.prices = prices;
        this.startDate = startDate;
        assignTicketToDate(startDate, duration, availableTickets); 
        }

    public int checkTicketOnDate(LocalDate date){
    	return avTicketsFest.get(date);
    }

    
    
    
    @Override
    public LocalDate startDate() {
        return startDate;
    }


    
    @Override
    public int price(int days) {
        return prices[days-1];
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

    private void assignTicketToDate(LocalDate startDate, int duration, int availableTickets){
    	for(int i = 0; i < duration; i++){
    		avTicketsFest.put(startDate, availableTickets);
    		startDate.plusDays(1);
    	}
    }
    
    
}
