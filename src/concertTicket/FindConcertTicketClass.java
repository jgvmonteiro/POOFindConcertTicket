package concertTicket;

import concertTicket.util.OrderList;
import concertTicket.util.OrderListClass;
import concertTicket.comparator.DateComparator;
import concertTicket.comparator.MostSoldComparator;
import concertTicket.event.*;
import concertTicket.exceptions.*;
import concertTicket.users.*;
import concertTicket.ticket.*;
import concertTicket.artist.*;
import static concertTicket.FindConcertTicket.USER_TYPE.*;

import concertTicket.comparator.TicketTypeComparator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Joao Monteiro, Diogo Tavares 
 */
public class FindConcertTicketClass implements FindConcertTicket {

    private User currentUser;
    private Map<String,Artist> artists;
    private Map<String,User> users;
    private Map<EVENT_TYPE,List<Event>> eventsType;
    private List<Event> eventsList;
    private OrderList<Event> eventsMostSold;
    private Map<String, Map<EVENT_TYPE, OrderList<Event>>> artistEvents;
    private Map<LocalDate, Map<String,Event>> events;
    
    public FindConcertTicketClass() {
        this.events = new HashMap<LocalDate, Map<String,Event>>();
        this.artists = new HashMap<String,Artist>();
        this.users = new HashMap<String,User>();
        this.eventsType = new HashMap<EVENT_TYPE, List<Event>>();
        this.eventsType.put(EVENT_TYPE.CONCERT, new ArrayList<Event>());
        this.eventsType.put(EVENT_TYPE.FESTIVAL, new ArrayList<Event>());
        this.eventsList = new ArrayList<Event>();
        this.eventsMostSold = new OrderListClass<Event>(new MostSoldComparator(), false);
        this.artistEvents = new HashMap<String, Map<EVENT_TYPE, OrderList<Event>>>();
        this.currentUser = null;
    }

    @Override
    public void addArtist(String name, String[] listAlbuns) throws InvalidPrivilegeException, ArtistAlreadyExistsException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if (artists.containsKey(name)) 
            throw new ArtistAlreadyExistsException();
        Artist artist = new ArtistClass(name, listAlbuns);
        addartist(name, artist);
    }

    @Override
    public void addArtist(String name, String[] listAlbuns, String[] elements) throws InvalidPrivilegeException, ArtistAlreadyExistsException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if (artists.containsKey(name))
            throw new ArtistAlreadyExistsException();
        Artist artist = new BandClass(name, listAlbuns, elements);
        addartist(name, artist);
    }
   
    private void addartist(String name, Artist artist){
        artists.put(name, artist);
        artistEvents.put(name, new HashMap<EVENT_TYPE, OrderList<Event>>());
        artistEvents.get(name).put(EVENT_TYPE.CONCERT, new OrderListClass<Event>(new DateComparator(),true));
        artistEvents.get(name).put(EVENT_TYPE.FESTIVAL, new OrderListClass<Event>(new DateComparator(),true));
    }

    @Override
    public void addEvent(String eventName, String artistName, String description, LocalDate date, int avaiableTickets, int price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if(!artists.containsKey(artistName))
            throw new ArtistNotFoundException(artistName);
        if(events.containsKey(date) && events.get(date).containsKey(eventName))
            throw new EventAlreadyExistsException();
        Artist artist = artists.get(artistName);
        Event e = new ConcertClass(eventName, artist, date, description, avaiableTickets, price);
        if(!events.containsKey(date))
            events.put(date, new HashMap<String, Event>());
        events.get(date).put(eventName, e);
        artistEvents.get(artistName).get(EVENT_TYPE_CONCERT_STR).add(e);
        eventsType.get(EVENT_TYPE.CONCERT).add(e);
        eventsList.add(e);
        eventsMostSold.add(e);
    }

    @Override
    public void addEvent(String eventName, String description, LocalDate startDate,  String[][] aligment, int tickets, int[] price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException{
    	if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if(events.containsKey(startDate) && events.get(startDate).containsKey(eventName))
            throw new EventAlreadyExistsException();
        Map<LocalDate, Artist[]> mapAlignemnt = new TreeMap<LocalDate, Artist[]>();
        List<String> notFound = new ArrayList<String>();
        List<String> allArtists = new ArrayList<String>();
        for (int i = 0; i < aligment.length; i++) {
            LocalDate date = startDate.plusDays(i);
            Artist[] artists = new Artist[aligment[i].length];
            for (int j = 0; j < aligment[i].length; j++) 
                if(!this.artists.containsKey(aligment[i][j]))
                    notFound.add(aligment[i][j]);
                else{
                    artists[j] = this.artists.get(aligment[i][j]);
                    allArtists.add(aligment[i][j]);
                }
            mapAlignemnt.put(date, artists);
        }
        if(notFound.size()>0){
            throw new ArtistNotFoundException(notFound);
        }
        Event e = new FestivalClass(eventName, description, mapAlignemnt, startDate, tickets, price);
        if(!events.containsKey(startDate))
            events.put(startDate, new HashMap<String, Event>());
        events.get(startDate).put(eventName, e);
        for(String artist : allArtists)
            artistEvents.get(artist).get(EVENT_TYPE.FESTIVAL).add(e);
        eventsType.get(EVENT_TYPE.FESTIVAL).add(e);
        eventsList.add(e);
        eventsMostSold.add(e);
    }

    
    @Override
    public int buyTicket(String eventName, LocalDate startDate, int ticketCount)throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException{
    	if (!(currentUser instanceof Client)) 
            throw new InvalidPrivilegeException();
        if(!(events.containsKey(startDate) && events.get(startDate).containsKey(eventName)))
            throw new EventNotFoundException();
        Concert e = (Concert)events.get(startDate).get(eventName);
        Ticket t = e.buyTickets(ticketCount);
        ((Client)currentUser).addTicket(t);
        return t.totalPrice();
    }

    @Override
    public int buyTicket(String eventName, LocalDate startDate, LocalDate[] dates) throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException {
        if (!(currentUser instanceof Client)) 
            throw new InvalidPrivilegeException();
        if(!(events.containsKey(startDate) && events.get(startDate).containsKey(eventName)))
            throw new EventNotFoundException();
        Festival e = (Festival)events.get(startDate).get(eventName);
         Ticket t = e.buyTicket(dates);
        ((Client)currentUser).addTicket(t);
        return t.totalPrice();
    }

    @Override
    public void logIn(String email, String password) throws UserNotFoundException, UserAlreadyLoggedInException, AnotherUserLoggedInException, WrongPasswordException {
        if(!users.containsKey(email))
            throw new UserNotFoundException();
        User user = users.get(email);
        if(currentUser == user)
            throw new UserAlreadyLoggedInException();
        if(currentUser != null)
            throw new AnotherUserLoggedInException();
        if(!user.getPassword().equals(password))
            throw new WrongPasswordException();
        currentUser = user;
    }

    @Override
    public String logOut() throws LogoutException {
        String email;
    	if(currentUser == null)
            throw new LogoutException();
    	email = currentUser.getEmail();
        currentUser = null;
        return email;
    }
    
    @Override
    public String register(USER_TYPE type, String email) throws UserAlreadyLoggedInException, UserAlreadyExistsException {
    	if(currentUser!=null)
            throw new UserAlreadyLoggedInException();
        if(users.containsKey(email))
            throw new UserAlreadyExistsException();
        String passw;
        User user;
        if(type == ADMIN){
            passw = "admin"+(adminUsersCount()+1);
            user = new AdminClass(email, passw);
        }else{
            passw = "client"+(users.size() - adminUsersCount() +1);
            user = new ClientClass(email, passw);
        }
        users.put(email,user);
        return passw;
    }
    
    private int adminUsersCount(){
        int c = 0;
        for(User user : users.values())
            if(user instanceof Admin)
                c++;
        return c;
    }   

    @Override
    public Iterator<Event> listAllEvents() {
        return eventsList.iterator();
    }

    @Override
    public Iterator<Event> listMostSold() {
        return eventsMostSold.iterator();
    }


    @Override
    public Iterator<Event> listEventsByType(String type) throws UnknownEventTypeException{
        if(type.equalsIgnoreCase(EVENT_TYPE_CONCERT_STR))
            return eventsType.get(EVENT_TYPE.CONCERT).iterator();
        else if(type.equalsIgnoreCase(EVENT_TYPE_FESTIVAL_STR))
            return eventsType.get(EVENT_TYPE.FESTIVAL).iterator();
        else
            throw new UnknownEventTypeException();
    }

    @Override
    public Event checkEventData(String eventName, LocalDate date) throws EventNotFoundException {
        Map<String, Event> h = events.get(date);
        if(h == null)
            throw new EventNotFoundException();
        Event e = h.get(eventName);
        if(e == null)
        	throw new EventNotFoundException();
        return e;
    }

    @Override
    public ArtistEventIterator searchEventsWithArtist(String artistName) throws ArtistNotFoundException{
        if(!artists.containsKey(artistName))
            throw new ArtistNotFoundException();
      return new ArtistEventIteratorClass(artistEvents.get(artistName));
    }


    @Override
    public Iterator<Ticket> listTickets() {
       return ((Client)currentUser).ticketsIterator();
    }
    

    
    
    
    
    
    
    
    
    
    
    

}
