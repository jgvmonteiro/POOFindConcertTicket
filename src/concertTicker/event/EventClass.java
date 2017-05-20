
package concertTicker.event;

/**
 *
 * @author Joao Monteiro
 */
public class EventClass implements Event{

    String description;
    String name;

    
    public EventClass(String eventName, String description) {
        this.description = description;
        this.name = eventName;

    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String getEventName() {
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
    public boolean equals(String name) {
        return (this.name.equalsIgnoreCase(name));
    }
    
    
    
    
}
