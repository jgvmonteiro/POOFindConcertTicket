
package concertTicket.event;

import java.time.LocalDate;

/**
 * Represent an event with a name, a description and a start date
 * Festival or Concert
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Event{

    /**
     * 
     * @return event's name
     */
    String name();
    
    /**
     * 
     * @return event's description
     */
    String description();
    
    /**
     * If this event is a festival is the date the festival begins
     * if is a concert is the date of the concert
     * @return the start date of the event
     */
    LocalDate startDate();
    
    /**
     * If this event is a festival is the sum of the sold tickets of all dates
     * If this event is a concert is the sum of the people of each sold tickets
     * @return number of sold tickets 
     */
    int soldTickets();
    

    
}
