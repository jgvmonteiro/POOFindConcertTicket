
package concertTicket.event;

import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author Joao Monteiro
 */
public interface Event{

    String description();
    
    String name();
    
    LocalDate startDate();
    
    int soldTickets();
    

    
}
