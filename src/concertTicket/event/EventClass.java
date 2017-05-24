
package concertTicket.event;

import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public abstract class EventClass implements Event{ 

    private String description;
    private String name;
    
    public EventClass(String eventName, String description, int availableTickets) {
        this.description = description;
        this.name = eventName;
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
    public boolean equals(Event event) {
        if (this instanceof Concert && event instanceof Concert) {
            Concert conc = (Concert) event;
            return conc.equals(this);
        } else if (this instanceof Festival && event instanceof Festival) {
            Festival fest = (Festival) event;
            return fest.equals(this);
        }
      return false;
    }

    @Override
    public boolean equals(String name, LocalDate startDate){
    	return (this.name.equals(name) && startDate.isEqual(startDate));
    }
    
    
    
    
}
