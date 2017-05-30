package concertTicket.util;

import java.util.Iterator;

/**
 * A list that keeps a collection sorted according with a given comparator
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface OrderList<E> {

    /**
     * Add new Event to the collection
     * @param event event to add
     */
    void add(E event);
    
    /**
     * 
     * @return iterator to iterate through the collection
     */
    Iterator<E> iterator();
    
}
