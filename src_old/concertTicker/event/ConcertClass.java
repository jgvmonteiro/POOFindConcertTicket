
package concertTicker.event;

import concertTicker.artist.Artist;

/**
 *
 * @author Joao Monteiro
 */
public class ConcertClass extends EventClass implements Concert{
    
    private Artist artist;
    private String date;
    private int avaiableTickets;
    private int price;

    public ConcertClass(String eventName, Artist artist, String date, String description, int avaiableTickets, int price) {
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
    public String date() {
        return date;
    }

    @Override
    public int availableTickets() {
        return avaiableTickets;
    }

    @Override
    public void buyTickets(int amount) {
       avaiableTickets -= amount;
 
    }
    

    @Override
    public int price() {
        return price;
    }

    @Override
    public boolean equals(Event event) {
        if(event instanceof Concert){
            Concert conc = (Concert) event;
            if (conc.getEventName().equalsIgnoreCase(super.getEventName()) && conc.date().equalsIgnoreCase(date))
                return true;
        }
        return false;
    }

    
    

    
    
}
