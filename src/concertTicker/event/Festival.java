
package concertTicker.event;

import concertTicker.artist.Artist;

/**
 *
 * @author Joao Monteiro
 */
public interface Festival extends Event{

    Artist[] artist(); //peer day...
    String startDate();
    String endDate();
    int price(int[] days);
    int avaiableTickets(String date);
    void buyTicket(String date);
    boolean equals(Event event);
}
