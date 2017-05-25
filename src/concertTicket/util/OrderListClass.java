package concertTicket.util;

import concertTicket.event.Event;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class OrderListClass<E> implements OrderList<E>{

    private List<E> list;
    private Comparator<E> comparator;
    private boolean sortOnAdd;
    
    public OrderListClass(Comparator<E> comparator, boolean sortOnAdd) {
        this.list = new ArrayList<E>();
        this.comparator = comparator;
        this.sortOnAdd = sortOnAdd;
    }
    
    @Override
    public void add(E event) {
        list.add(event);
        if(sortOnAdd)
            Collections.sort(list, comparator);
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        if(!sortOnAdd)
            Collections.sort(list, comparator);
        return list.iterator();
    }

    
    
}
