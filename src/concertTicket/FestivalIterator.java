package concertTicket;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import concertTicket.event.Event;
import concertTicket.event.Festival;

public class FestivalIterator implements Iterator<Event>{

	private List<Event> list;
	private ListIterator<Event> it;
	
	public FestivalIterator(List<Event> list) {
        this.list = list;
        it = list.listIterator();
        searchNext();
    }

	public boolean hasNext(){
		return it.hasNext();
	}
	
	private void searchNext(){
		while(it.hasNext()){
			if(it.next() instanceof Festival){
				it.previous();
				return;
			}	
		}
	}
	
	public Festival next(){
		Festival next = (Festival) it.next();
		this.searchNext();
		return next;
	}
	
}
