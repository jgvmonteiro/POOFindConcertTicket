package concertTicket;


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
import concertTicket.ticket.Ticket;
import concertTicket.artist.Artist;
import concertTicket.event.Event;
import concertTicket.users.User;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Joao Monteiro
 */
public interface FindConcertTicket {
    
    enum USER_TYPE{
        ADMIN, CLIENT
    }
    
    
    ///////////////////////////ADMIN
    
    /**
     * Adds new individual artist to the collection
     * @param name artist name
     * @param listAlbuns artist career albums
     * @throws InvalidPrivilegeException current user logged in is not an Administrator
     * @throws ArtistAlreadyExistsException given artist name already exists
     */
    void addArtist(String name, String[] listAlbuns) throws InvalidPrivilegeException, ArtistAlreadyExistsException;;
    
    /**
     * Adds new artist band to the collection
     * @param name band name
     * @param listAlbuns band career albums
     * @param elements band elements names
     * @throws InvalidPrivilegeException current user logged in is not an Administrator
     * @throws ArtistAlreadyExistsException given artist already exists
     */
    void addArtist(String name, String[] listAlbuns, String[] elements) throws InvalidPrivilegeException, ArtistAlreadyExistsException;
    
    /**
     * Check if artist exist in the collection
     * @param name artist name to verify
     * @return true if exists, false otherwise
     */
    boolean hasArtist(String name);
    
    /**
     * Search the collection for the specified artist name
     * @param name artist name to search
     * @return Artist object of the given name
     * @throws ArtistNotFoundException artist given name not found in the collection
     */
    Artist getArtist(String name) throws ArtistNotFoundException;
    
    /**
     * Adds new concert type event to the collection
     * @param eventName concert's event name
     * @param artistName artist name to perform in this event
     * @param description concert's description
     * @param date event date
     * @param availableTickets number of tickets available to sell for this event
     * @param price price of each ticket
     * @throws InvalidPrivilegeException current user logged in is not an Administrator
     * @throws EventAlreadyExistsException the event already exists in the collection
     * @throws ArtistNotFoundException given artist name not found
     */
    void addEvent(String eventName, String artistName, String description, String date, int availableTickets, int price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException;
    
    /**
     * Adds new festival type event to the collection
     * @param eventName festival's name
     * @param description festival's description
     * @param alignment festival artists alignment according with the date to perform
     * @param startDate festival start date
     * @param tickets available tickets to the festival
     * @param price price according the number o day the ticket has access to 
     * @throws InvalidPrivilegeException current user logged in is not an Administrator
     * @throws EventAlreadyExistsException the event already exists in the collection
     * @throws ArtistNotFoundException ArtistNotFoundException given artist name not found
     */
    void addEvent(String eventName, String description, String startDate,  String[][] aligment, int tickets, int[] price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException;
   
    /**
     * Check if event exists in the collection
     * @param eventName event's name to verify
     * @return true if event exists, false otherwise
     */
    boolean hasEvent(String eventName, LocalDate startDate);
    
    /**
     * Searches events collection for the specified event name
     * @param eventName event name to search
     * @return Event object of the given name
     * @throws EventNotFoundException event name not found in the collection
     */
    Event getEvent(String eventName, LocalDate startDate) throws EventNotFoundException;
    
    //////////////////////////CLIENT
    
    /**
     * Buys ticket for a concert event
     * @param eventName concert event name
     * @param startDate concert  date
     * @param ticketCount number of thickets to buy
     * @throws InvalidPrivilegeException current user logged in is not a Client
     * @throws EventNotFoundException event name not found in the collection
     * @throws EventSoldOutException event has less available tickets than the <var>ticketCount</var> amount supplied
     */
    void buyTicket(String eventName, LocalDate startDate, int ticketCount) throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException;
    
    /**
     * Buys ticket for a festival event
     * @param eventName festival event name
     * @param startDate festival start date
     * @param dates string array with the dates of the event client wishes to go
     * @throws InvalidPrivilegeException
     * @throws EventNotFoundException
     * @throws EventSoldOutException 
     */
    void buyTicket(String eventName, LocalDate startDate, LocalDate[] dates) throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException;
    
    /**
     * To list all tickets owned by a specific user. Tickets are ordered by purchase date, from oldest to most recent.
     * @return iterator containing all tickets bought by the user currently logged in
     */
    Iterator<Ticket> listTickets();
    
    ///////////////////LOGIN AND LOGOUT
    
    
    /**
     * Logs in a new user
     * @param email user's email
     * @param password user's password
     * @throws UserNotFoundException user email not found
     * @throws UserAlreadyLoggedInException user is already logged in
     * @throws AnotherUserLoggedInException can't log in 'cause other user is already logged in
     * @throws WrongPasswordException wrong password 
     */
    void logIn(String email, String password) throws UserNotFoundException, UserAlreadyLoggedInException, AnotherUserLoggedInException, WrongPasswordException;
    
    /**
     * Logs out the current logged user
     * @return email of user to be logged out
     * @throws LogoutException if no one is logged in
     */
    String logOut() throws LogoutException;
 
    /**
     * Check if user exists in the system
     * @param email user's email to verify
     * @return true if user exists, false otherwise
     */
    boolean hasUser(String email);
    
    /**
     * Searches for a user in the collection
     * @param email user email to search
     * @return User object of the given email
     * @throws UserNotFoundException no user with the given email found in the collection
     */
    User getUser(String email) throws UserNotFoundException;


    /////////////////// ALL USERS
    
    /**
     * Registers new user to the system
     * @param type type of use to register ADMIN or CLIENT
     * @param email user email
     * @return user generated password
     * @throws UserAlreadyLoggedInException
     * @throws UserAlreadyExistsException 
     */
    String register(USER_TYPE type, String email) throws UserAlreadyLoggedInException, UserAlreadyExistsException;

    /**
     * To list all events in the system
     * @return iterator containing all events in the collection
     */
    Iterator<Event> listAllEvents();
    
    /**
     * To list all events in the system, ordered from most to least sales.
     * In case of a tie, closest date to current time comes first. 
     * If two or more events have the same date and sales, they're listed alphabetically.
     * @return iterator containing all ordered events in the collection
     */
    Iterator<Event> listMostSold();
    
    /**
     * To list events from a specific type (shows or festivals)
     * @param type to be listed
     * @return iterator containing all events of a given type
     * @throws UnknownEventTypeException if <code>type</code> is an unknown show type
     */
    Iterator<Event> listEventsByType(String type) throws UnknownEventTypeException;
    
    /**
     * To check an event's data
     * @param eventName
     * @param date
     * @return event whose data will be checked
     * @throws EventNotFoundException if event doesn't exist
     */
    Event checkEventData(String eventName, String date) throws EventNotFoundException;
    
    /**
     * To list event in which an individual artist (not band member) will play
     * @param artistName
     * @return iterator of events
     */
    Iterator<Event> searchEventsWithArtist(String artistName);// no enunciado nao diz o que acontece quando alguma coisa corre mal mas deve throwar um artistnotfoundexception
    
    
    //////////////////// MISC
    

}
