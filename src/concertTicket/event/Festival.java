
package concertTicket.event;

import concertTicket.exceptions.EventSoldOutException;
import concertTicket.ticket.FestivalTicket;
import java.time.LocalDate;

/**
 * Represents festival with a number of artists to each date
 * Contains informations about the festival
 * Allows to buy tickets for the festival
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface Festival extends Event{

    /**
     * This price according to the number of days client wants to access this festival
     * @param days number of days
     * @return price according with the number of days
     */
    int price(int days);
    
    /**
     * Festival duration
     * @return number of days of the festival
     */
    int duration();
    
    /**
     * Buys a ticket to the given dates
     * @param dates dates client wishes to go 
     * @return bought ticket 
     * @throws EventSoldOutException one or more f the given dates has sold out
     */
    FestivalTicket buyTicket(LocalDate[] dates) throws EventSoldOutException;
    
    /**
     * Number of available tickets according with the date
     * @param date date to check
     * @return number of available tickets in the given date
     */
    int availableTickets(LocalDate date);
    
    /**
     * Allow to iterate through festival alignment 
     * @return custom iterator FestivalDataIterator
     */
    FestivalDataIterator alignmentIterator();
}
