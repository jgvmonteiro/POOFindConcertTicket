
package concertTicket.ticket;

import java.time.LocalDate;


/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class FestivalTicketClass extends TicketClass implements FestivalTicket{

    LocalDate[] dates;
    
    /**
     * 
     * @param eventName event's name
     * @param dates festival dates
     * @param totalPrice total price of this ticket
     */
    public FestivalTicketClass(String eventName, LocalDate[] dates, int totalPrice) {
        super(eventName,totalPrice);
        this.dates = dates;
    }

    @Override
    public LocalDate[] dates() {
        return dates;
    }

    
    
}
