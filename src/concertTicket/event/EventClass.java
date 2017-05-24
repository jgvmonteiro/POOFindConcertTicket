
package concertTicket.event;

import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
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
