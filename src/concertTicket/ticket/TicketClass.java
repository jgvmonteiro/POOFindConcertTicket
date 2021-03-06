
package concertTicket.ticket;


/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public abstract class TicketClass implements Ticket{
    
    String eventName;
    int totalPrice;
    
    /**
     * 
     * @param eventName event's name
     * @param totalPrice this ticket total price
     */
    public TicketClass(String eventName, int totalPrice) {
        this.eventName = eventName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String eventName() {
        return eventName;
    }


    @Override
    public int totalPrice() {
        return totalPrice;
    }
    
    
    
    public int compareTo(Ticket t){
    	return 0;
    }

    
    
    
}
