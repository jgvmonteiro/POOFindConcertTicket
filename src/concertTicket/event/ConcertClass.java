
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
    private LocalDate date;
    private int price;
    int ticketsSold, capacity;

    
    public ConcertClass(String eventName, Artist artist, LocalDate date, String description, int availableTickets, int price) {
        super(eventName, description, availableTickets);
        this.artist = artist;
        this.date = date;
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
    public LocalDate date() {
        return date;
    }


    @Override
    public ConcertTicket buyTickets(int amount) {
       sellTickets(amount);
       return new ConcertTicketClass(name(), date, amount, price);
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
            if (conc.name().equalsIgnoreCase(super.name()) && conc.date().isEqual(date))
                return true;
        }
        return false;
    }


	

    
    

    
    
}
