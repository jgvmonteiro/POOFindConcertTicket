
package concertTicket.event;

import java.time.LocalDate;

/**
 * This class implements Event interface
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public abstract class EventClass implements Event{ 

    private String description;
    private String name;
    LocalDate startDate;
    
    public EventClass(String eventName, String description, LocalDate startDate) {
        this.description = description;
        this.name = eventName;
        this.startDate = startDate;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public LocalDate startDate() {
        return startDate;
    }
    

    
    
    
    
    
}
