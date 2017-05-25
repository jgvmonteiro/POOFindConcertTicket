
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.exceptions.EventSoldOutException;
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
    private int[] prices;
    private Map<LocalDate, Integer> soldTickets;
    private int capacityPERday;
    
    public FestivalClass(String name, String description, Map<LocalDate,Artist[]> alignment, LocalDate startDate, int capacity, int[] prices) {
        super(name, description, startDate);
        this.alignemnt = alignment;
        this.prices = prices;
        this.capacityPERday = capacity;
        this.soldTickets = new HashMap<LocalDate, Integer>(alignment.size());
        for(LocalDate date : alignment.keySet())
            soldTickets.put(date, 0);
    }

    @Override
    public int availableTickets(LocalDate date){
    	return (capacityPERday-soldTickets.get(date));
    }

    @Override
    public int soldTickets() {
        int total = 0;
        for(Integer val : soldTickets.values())
            total+=val;
        return total;
    }
    
    @Override
    public int duration() {
        return alignemnt.size();
    }
    
    
    
    @Override
    public int price(int days) {
        return prices[days-1];
    }
    
    @Override
    public FestivalTicket buyTicket(LocalDate[] dates) throws EventSoldOutException{
        for(LocalDate date:dates)
            if(availableTickets(date)>0)
                soldTickets.replace(date, soldTickets.get(date)+1);
            else
                throw new EventSoldOutException();
        return new FestivalTicketClass(name(), dates, prices[dates.length-1]);
    }

    @Override
    public FestivalDataIterator alignmentIterator() {
        return new FestivalIteratorClass(alignemnt);
    } 

    @Override
    public boolean equals(Event event) {
        if(event instanceof Festival){
            Festival fest = (Festival)event;
            if(fest.name().equalsIgnoreCase(name()) && fest.startDate().isEqual(startDate()))
                return true;
       }
        return false;
    }
 
}
