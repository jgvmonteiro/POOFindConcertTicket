package concertTicket;

import concertTicket.event.Event;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Joao Monteiro
 */
public class IteratorByType implements Iterator<Event> {

    private ListIterator<Event> it;
    private List<Event> list;
    private Class type;

    public IteratorByType(List<Event> list, Class TYPE) {
        this.list = list;
        this.type = TYPE;
        it = list.listIterator();
        searchNext();
    }

    private void searchNext() {
        while (it.hasNext()) {
            if (it.next().getClass().isAssignableFrom(type)) {
                it.previous();
                return;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Event next() {
        Event next = it.next();
        searchNext();
        return next;
    }


}
