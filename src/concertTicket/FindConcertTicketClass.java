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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joao Monteiro, Diogo Tavares 
 */
public class FindConcertTicketClass implements FindConcertTicket {

    User currentUser;
    List<Event> events;
    List<Artist> artists;
    List<User> users;

    public FindConcertTicketClass() {
        this.events = new ArrayList();
        this.artists = new ArrayList();
        this.users = new ArrayList();
        this.currentUser = null;
    }

    @Override
    public void addArtist(String name, String[] listAlbuns) throws InvalidPrivilegeException, ArtistAlreadyExistsException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if (hasArtist(name)) 
            throw new ArtistAlreadyExistsException();
        Artist artist = new ArtistClass(name, listAlbuns);
        artists.add(artist);
    }

    @Override
    public void addArtist(String name, String[] listAlbuns, String[] elements) throws InvalidPrivilegeException, ArtistAlreadyExistsException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        if (hasArtist(name))
            throw new ArtistAlreadyExistsException();
        Artist artist = new BandClass(name, listAlbuns, elements);
        artists.add(artist);
    }

    @Override
    public boolean hasArtist(String name) {
        try {
            getArtist(name);
            return true;
        } catch (ArtistNotFoundException e) {
            return false;
        }
    }

    @Override
    public Artist getArtist(String name) throws ArtistNotFoundException {
        for (Artist artist : artists) 
            if (artist.getName().equalsIgnoreCase(name)) 
                return artist;
        throw new ArtistNotFoundException();
    }
    
    

    @Override
    public void addEvent(String eventName, String artistName, String description, LocalDate date, int avaiableTickets, int price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException {
        if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
        
        Artist artist = getArtist(artistName);
        if(hasEvent(eventName, date))
            throw new EventAlreadyExistsException();
        
        Event e = new ConcertClass(eventName, artist, date, description, avaiableTickets, price);
        events.add(e);
    }

    @Override
    public void addEvent(String eventName, String description, LocalDate startDate,  String[][] aligment, int tickets, int[] price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException{
    	if (!(currentUser instanceof Admin)) 
            throw new InvalidPrivilegeException();
    	
        if(hasEvent(eventName, startDate))
            throw new EventAlreadyExistsException();
        
        //para verificar o artistdoesnotexist usamos uma linked list
        //Event e = new FestivalClass(eventName, description, artists, startDate, days, avaiableTickets, price);
        //events.add(e);
    }

    @Override
    public boolean hasEvent(String eventName, LocalDate startDate) {
        try {
            getEvent(eventName, startDate);
            return true;
        } catch (Exception e) {}
        return false;
    }

    @Override
    public Event getEvent(String eventName, LocalDate startDate) throws EventNotFoundException {
    	for(Event e: events)
            if(e.equals(eventName, startDate))
                return e;
        throw new EventNotFoundException();
    }

    @Override
    public void buyTicket(String eventName, LocalDate startDate, int ticketCount)throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException{
        if (!(currentUser instanceof Client)) 
            throw new InvalidPrivilegeException();
        
        Concert e = (Concert)getEvent(eventName, startDate);
        if(ticketCount > e.availableTickets())
            throw new EventSoldOutException();
        
        e.buyTickets(ticketCount);
        ((Client)currentUser).addEvent(e);
    }

    @Override
    public void buyTicket(String eventName, LocalDate startDate, LocalDate[] dates) throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException {
        if (!(currentUser instanceof Client)) 
            throw new InvalidPrivilegeException();
        Festival e = (Festival)getEvent(eventName,startDate);
        if(e.avaiableTickets()==0)
            throw new EventSoldOutException();  
         e.buyTicket(dates);
        ((Client)currentUser).addEvent(e);
    }

    @Override
    public void logIn(String email, String password) throws UserNotFoundException, UserAlreadyLoggedInException, AnotherUserLoggedInException, WrongPasswordException {
        User user = getUser(email);
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
    public User getUser(String email) throws UserNotFoundException {
        for (User user : users)
            if(user.getEmail().equalsIgnoreCase(email))
                return user;
        throw new UserNotFoundException();
    }

    @Override
    public boolean hasUser(String email){
        try {
            getUser(email);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    @Override
    public String register(USER_TYPE type, String email) throws UserAlreadyLoggedInException, UserAlreadyExistsException { //throws WrongTypeException, but it's not tested    	
    	if(currentUser!=null)
            throw new UserAlreadyLoggedInException();
        if(hasUser(email))
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
        users.add(user);
        return passw;
    }
    
    private int adminUsersCount(){
        int c = 0;
        for(User user : users)
            if(user instanceof Admin)
                c++;
        return c;
    }   

    @Override
    public Iterator<Event> listAllEvents() {
        return events.iterator();
    }

    @Override
    public Iterator<Event> listMostSold() {
 
        return null;
        
    }

	
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
		return null;
	}
    

    
    
    
    
    
    
    
    
    
    
    

}
