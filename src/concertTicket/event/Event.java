
package concertTicket.event;

/**
 *
 * @author Joao Monteiro
 */
public interface Event {

    String description();
    
    String name();
    
    
    
    boolean equals(Event event);
    
    boolean equals(String name);
}
