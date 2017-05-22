
package concertTicker.event;

import concertTicker.artist.Artist;
import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface Concert extends Event{

    Artist artist();
    LocalDate date();
    String description();
    int availableTickets();
    void buyTickets(int amount);
    int price();
    boolean equals(Event event);
    
    
    
}
