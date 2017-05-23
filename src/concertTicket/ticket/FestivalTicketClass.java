
package concertTicket.ticket;

import java.time.LocalDate;


/**
 *
 * @author Joao Monteiro
 */
public class FestivalTicketClass extends TicketClass implements FestivalTicket{

    String[] dates;
    
    public FestivalTicketClass(String eventName, String[] dates, int totalPrice) {
        super(eventName,totalPrice);
        this.dates = dates;
    }

    @Override
    public String[] dates() {
        return dates;
    }

    
    
}
