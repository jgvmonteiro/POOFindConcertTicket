
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.ticket.FestivalTicket;
import concertTicket.ticket.FestivalTicketClass;
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
        return startDate;
    }

    @Override
    public int price(int days) {
        return prices[days-1];
    }

    @Override
    public int avaiableTickets() {
        return availableTickets;
    }

    @Override
    public FestivalTicket buyTicket(String[] dates) {
        availableTickets-= dates.length; //Verificar se as datas existem???
        return new FestivalTicketClass(name, dates, prices[dates.length-1]);
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
