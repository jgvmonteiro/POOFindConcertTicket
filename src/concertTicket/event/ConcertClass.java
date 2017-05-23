
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
    private int avaiableTickets;
    private int price;

    public ConcertClass(String eventName, Artist artist, LocalDate date, String description, int avaiableTickets, int price) {
        super(eventName, description);
        this.artist = artist;
        this.date = date;
        this.avaiableTickets = avaiableTickets;
        this.price = price;
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
    public int availableTickets() {
        return avaiableTickets;
    }

    @Override
    public ConcertTicket buyTickets(int amount) {
       avaiableTickets -= amount;
       return new ConcertTicketClass(name, date, amount, price);
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
