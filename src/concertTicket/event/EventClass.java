
package concertTicket.event;

import java.time.LocalDate;

/**
 *
 * @author Joao Monteiro
 */
public abstract class EventClass implements Event{ 

    private String description;
    private String name;
    private int ticketsSold, capacity;
    
    public EventClass(String eventName, String description, int availableTickets) {
        this.description = description;
        this.name = eventName;
        this.capacity = availableTickets;
        this.ticketsSold = 0;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String name() {
        return name;
    }

    public int availableTickets(){
    	return capacity - ticketsSold;
    }
    
    public void sellTickets(int amount){
    	ticketsSold += amount;
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
