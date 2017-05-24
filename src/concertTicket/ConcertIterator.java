package concertTicket;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import concertTicket.event.Concert;
import concertTicket.event.Event;

public class ConcertIterator implements Iterator<Event>{

	private List<Event> list;
	private ListIterator<Event> it;
	
	public ConcertIterator(List<Event> list) {
        this.list = list;
        it = list.listIterator();
        searchNext();
    }

	public boolean hasNext(){
		return it.hasNext();
	}
	
	private void searchNext(){
		while(it.hasNext()){
			if(it.next() instanceof Concert){
				it.previous();
				return;
			}	
		}
	}
	
	public Concert next(){
		Concert next = (Concert) it.next();
		this.searchNext();
		return next;
	}
	
}
