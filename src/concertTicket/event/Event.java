
package concertTicket.event;

import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author Joao Monteiro
 */
public interface Event extends Comparable<Event>{

    String description();
    
    String name();
    
    LocalDate startDate();
    
    int soldTickets();
    
    boolean equals(Event event);
        
    boolean equals(String name, LocalDate startDate);
    
}
