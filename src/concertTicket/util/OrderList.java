package concertTicket.util;

import concertTicket.event.Event;
import java.util.Iterator;

/**
 *
 * @author Joao Monteiro
 */
public interface OrderList<E> {

    void add(E event);
    E get(int index);
    Iterator<E> iterator();
    
}
