
package concertTicket.event;

import concertTicket.artist.Artist;
import concertTicket.exceptions.EventSoldOutException;
import concertTicket.ticket.ConcertTicket;
import concertTicket.ticket.ConcertTicketClass;
import java.time.LocalDate;

/**
 * This class implements Concert interface
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class ConcertClass extends EventClass implements Concert{
    
    private Artist artist;
    private int price;
    int soldTickets, capacity;

    /**
     * 
     * @param eventName event's name
     * @param artist artist's name
     * @param date event's date
     * @param description event's description
     * @param capacity concert max capacity
     * @param price concert price per person
     */
    public ConcertClass(String eventName, Artist artist, LocalDate date, String description, int capacity, int price) {
        super(eventName, description, date);
        this.artist = artist;
        this.price = price;
        this.capacity = capacity;
        this.soldTickets = 0;

    }

    @Override
    public Artist artist() {
        return artist;
    }

    @Override
    public ConcertTicket buyTickets(int amount) throws EventSoldOutException{
       if(availableTickets()>=amount)
           soldTickets+=amount;
       else
           throw new EventSoldOutException();
       return new ConcertTicketClass(name(), startDate(), amount, price);
    }
    
    public int availableTickets(){
    	return capacity - soldTickets;
    }

    @Override
    public int soldTickets() {
       return soldTickets;
    }
    
    @Override
    public int price() {
        return price;
    }



	

    
    

    
    
}
