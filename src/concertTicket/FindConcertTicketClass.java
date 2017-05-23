package concertTicket;

import concertTicket.event.Festival;
import concertTicket.event.Event;
import concertTicket.event.ConcertClass;
import concertTicket.event.Concert;
import concertTicket.exceptions.ArtistAlreadyExistsException;
import concertTicket.exceptions.UserAlreadyLoggedInException;
import concertTicket.exceptions.WrongPasswordException;
import concertTicket.exceptions.EventSoldOutException;
import concertTicket.exceptions.EventNotFoundException;
import concertTicket.exceptions.UserNotFoundException;
import concertTicket.exceptions.UnknownEventTypeException;
import concertTicket.exceptions.UserAlreadyExistsException;
import concertTicket.exceptions.ArtistNotFoundException;
import concertTicket.exceptions.EventAlreadyExistsException;
import concertTicket.exceptions.LogoutException;
import concertTicket.exceptions.InvalidPrivilegeException;
import concertTicket.exceptions.AnotherUserLoggedInException;
import concertTicket.users.Client;
import concertTicket.users.Admin;
import concertTicket.users.AdminClass;
import concertTicket.users.ClientClass;
import concertTicket.users.User;
import concertTicket.ticket.Ticket;
import concertTicket.artist.Artist;
import concertTicket.artist.BandClass;
import concertTicket.artist.ArtistClass;
import static concertTicket.FindConcertTicket.USER_TYPE.*;
import concertTicket.event.FestivalClass;
import concertTicket.ticket.TicketTypeComparator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joao Monteiro, Diogo Tavares 
 */
public class FindConcertTicketClass implements FindConcertTicket {

    User currentUser;
    Map<String,Artist> artists;
    Map<String,User> users;
    List<Event> eventsList;
    Map<String, List<Event>> artistEvents;
    Map<LocalDate, Map<String,Event>> events;
    
    public FindConcertTicketClass() {
        this.events = new HashMap<LocalDate, Map<String,Event>>();
        this.artists = new HashMap<String,Artist>();
        this.users = new HashMap<String,User>();
        this.eventsList = new ArrayList<Event>();
        this.currentUser = null;
        this.artistEvents = new HashMap<String, List<Event>>();
    }

    @Override
    public void addArtist(String name, String[] listAlbuns) throws InvalidPrivilegeException, ArtistAlreadyExistsException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if (artists.containsKey(name)) 
            throw new ArtistAlreadyExistsException();
        Artist artist = new ArtistClass(name, listAlbuns);
        artists.put(name, artist);
        artistEvents.put(name, new ArrayList<Event>());
    }

    @Override
    public void addArtist(String name, String[] listAlbuns, String[] elements) throws InvalidPrivilegeException, ArtistAlreadyExistsException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if (artists.containsKey(name))
            throw new ArtistAlreadyExistsException();
        Artist artist = new BandClass(name, listAlbuns, elements);
        artists.put(name, artist);
        artistEvents.put(name, new ArrayList<Event>());
    }
    

    @Override
    public void addEvent(String eventName, String artistName, String description, LocalDate date, int avaiableTickets, int price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if(!artists.containsKey(artistName))
            throw new ArtistNotFoundException();
        if(events.containsKey(date) && events.get(date).containsKey(eventName))
            throw new EventAlreadyExistsException();
        Artist artist = artists.get(artistName);
        Event e = new ConcertClass(eventName, artist, date, description, avaiableTickets, price);
        if(!events.containsKey(date))
            events.put(date, new HashMap<String, Event>());
        events.get(date).put(eventName, e);
        artistEvents.get(artistName).add(e);
        eventsList.add(e);
    }

    @Override
    public void addEvent(String eventName, String description, LocalDate startDate,  String[][] aligment, int tickets, int[] price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException{
    	if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if(events.containsKey(startDate) && events.get(startDate).containsKey(eventName))
            throw new EventAlreadyExistsException();
        Map<LocalDate, Artist[]> mapAlignemnt = new HashMap<LocalDate, Artist[]>();
        List<String> notFound = new ArrayList<String>();
        Artist[] artists = null;
        for (int i = 0; i < aligment.length; i++) {
            LocalDate date = startDate.plusDays(i);
            artists = new Artist[aligment[i].length];
            for (int j = 0; j < aligment[i].length; j++) 
                if(!this.artists.containsKey(aligment[i][j]))
                    notFound.add(aligment[i][j]);
                else
                    artists[j] = this.artists.get(aligment[i][j]);
            mapAlignemnt.put(date, artists);
        }
        if(notFound.size()>0)
            throw new ArtistNotFoundException((String[])notFound.toArray());
        Event e = new FestivalClass(eventName, description, mapAlignemnt, startDate, aligment.length, tickets, price);
        if(!events.containsKey(startDate))
            events.put(startDate, new HashMap<String, Event>());
        events.get(startDate).put(eventName, e);
        for(Artist artist : artists)
            artistEvents.get(artist.getName()).add(e);
        eventsList.add(e);
    }

    @Override
    public int buyTicket(String eventName, LocalDate startDate, int ticketCount)throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException{
    	if (!(currentUser instanceof Client)) 
            throw new InvalidPrivilegeException();
        if(!(events.containsKey(startDate) && events.get(startDate).containsKey(eventName)))
            throw new EventNotFoundException();
        Concert e = (Concert)events.get(startDate).get(eventName);
        if(ticketCount > e.availableTickets())
            throw new EventSoldOutException();
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
        if(e.availableTickets()==0)
            throw new EventSoldOutException();  
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
 
        return null;
        
    }


    @Override
    public Iterator<Event> listEventsByType(String type) throws UnknownEventTypeException{

            return null;
    }

    @Override
    public Event checkEventData(String eventName, String date) throws EventNotFoundException {

            return null;
    }

    @Override
    public Iterator<Event> searchEventsWithArtist(String artistName) {

            return null;
    }


    @Override
    public Iterator<Ticket> listTickets() {
       List<Ticket> l =  ((Client)currentUser).myTickets();
       l.sort(new TicketTypeComparator());
       return l.iterator();
    }
    

    
    
    
    
    
    
    
    
    
    
    

}
