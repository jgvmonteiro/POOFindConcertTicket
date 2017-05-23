
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
    private int duration;
    private int[] prices;  
    private LocalDate startDate;
    
    public FestivalClass(String name, String description, Map<LocalDate,Artist[]> alignment, LocalDate startDate, int duration, int availableTickets, int[] prices) {
        super(name, description, availableTickets);
        this.duration = duration;
        this.prices = prices;
        this.startDate = startDate;
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
    public FestivalTicket buyTicket(LocalDate[] dates) {
        sellTickets(dates.length); //Verificar se as datas existem???
        return new FestivalTicketClass(name(), dates, prices[dates.length-1]);
    }

    @Override
    public String[][] getAlignmentStr() {
        String[][] r = new String[alignemnt.size()][];
        int i =0; int j = 0;
        for(LocalDate date : alignemnt.keySet()){
            String[] artists = new String[alignemnt.get(date).length];
            for (Artist artist: alignemnt.get(date)) {
                artists[j++] = artist.getName();
            }
            
        }
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
