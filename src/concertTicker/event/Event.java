
package concertTicker.event;

/**
 *
 * @author Joao Monteiro
 */
public interface Event {

    String description();
    
    String getEventName();
    

    
    boolean equals(Event event);
    
    boolean equals(String name);
}
