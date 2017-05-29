package concertTicket.util;

import java.util.Iterator;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface OrderList<E> {

    void add(E event);
    E get(int index);
    Iterator<E> iterator();
    
}
