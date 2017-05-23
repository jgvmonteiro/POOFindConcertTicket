
package concertTicket.ticket;

import java.time.LocalDate;


/**
 *
 * @author Joao Monteiro
 */
public class FestivalTicketClass extends TicketClass implements FestivalTicket{

    LocalDate[] dates;
    
    public FestivalTicketClass(String eventName, LocalDate[] dates, int totalPrice) {
        super(eventName,totalPrice);
        this.dates = dates;
    }

    @Override
    public LocalDate[] dates() {
        return dates;
    }

    
    
}
