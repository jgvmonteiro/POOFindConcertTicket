
package concertTicket.event;

import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Event{

    String description();
    
    String name();
    
    LocalDate startDate();
    
    int soldTickets();
    

    
}
