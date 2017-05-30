package concertTicket.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class OrderListClass<E> implements OrderList<E>{

    private List<E> list;
    private Comparator<E> comparator;
    private boolean sortOnAdd;
    
    public OrderListClass(Comparator<E> comparator, boolean sortOnAdd) {
        this.list = new LinkedList<E>();
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
    public Iterator<E> iterator() {
        if(!sortOnAdd)
            Collections.sort(list, comparator);
        return list.iterator();
    }

    
    
}
