
package concertTicket.event;

import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public interface Event {

    String description();
    
    String name();
    
    int getAvailableTickets();
    
    void sellTickets(int amount);
    
    
    boolean equals(Event event);
        
    boolean equals(String name, LocalDate startDate);
}
