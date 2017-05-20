
package concertTicker.event;

import concertTicker.artist.Artist;

/**
 *
 * @author Joao Monteiro
 */
public interface Concert extends Event{

    Artist artist();
    String date();
    String description();
    int availableTickets();
    void buyTickets(int amount);
    int price();
    boolean equals(Event event);
    
    
    
}
