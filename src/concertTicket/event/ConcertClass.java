
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.ticket.ConcertTicket;
import concertTicket.ticket.ConcertTicketClass;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public class ConcertClass extends EventClass implements Concert{
    
    private Artist artist;
    private int price;
    int ticketsSold, capacity;

    
    public ConcertClass(String eventName, Artist artist, LocalDate date, String description, int availableTickets, int price) {
        super(eventName, description, date,  availableTickets);
        this.artist = artist;
        this.price = price;
        this.capacity = availableTickets;
        this.ticketsSold = 0;

    }
    
    public void sellTickets(int amount){
    	ticketsSold += amount;
    }


    @Override
    public Artist artist() {
        return artist;
    }

    @Override
    public ConcertTicket buyTickets(int amount) {
       sellTickets(amount);
       return new ConcertTicketClass(name(), startDate(), amount, price);
    }
    
    public int availableTickets(){
    	return capacity - ticketsSold;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public boolean equals(Event event) {
        if(event instanceof Concert){
            Concert conc = (Concert) event;
            if (conc.name().equalsIgnoreCase(super.name()) && conc.startDate().isEqual(startDate))
                return true;
        }
        return false;
    }


	

    
    

    
    
}
