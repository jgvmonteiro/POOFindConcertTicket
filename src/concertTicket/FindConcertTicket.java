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
import concertTicket.artist.ArtistEventIterator;
import concertTicket.event.Event;
import java.time.LocalDate;
import java.util.Iterator;

/**
 * FindConcertTicket main class
 * Contains all the necessary methods to interact with the application.
 * 
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface FindConcertTicket {
    
    String ADMIN_STR = "admin";
    String CLIENT_STR = "client";
    String EVENT_TYPE_CONCERT_STR = "CONCERT";
    String EVENT_TYPE_FESTIVAL_STR= "FESTIVAL";
	
    enum USER_TYPE{
        ADMIN, CLIENT
    }
    
    enum EVENT_TYPE{
        FESTIVAL, CONCERT
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
     * @param name band name string
     * @param listAlbuns band career albums string array
     * @param elements band elements names string array
     * @throws InvalidPrivilegeException current user logged in is not an Administrator
     * @throws ArtistAlreadyExistsException given artist already exists
     */
    void addArtist(String name, String[] listAlbuns, String[] elements) throws InvalidPrivilegeException, ArtistAlreadyExistsException;
    
    /**
     * Adds new concert type event to the collection
     * @param eventName event's name
     * @param artistName artist's name to perform in this event
     * @param description event's description
     * @param date event date
     * @param availableTickets number of tickets available to sell for this event
     * @param price price of each ticket
     * @throws InvalidPrivilegeException current user logged in is not an Administrator
     * @throws EventAlreadyExistsException the event already exists in the collection
     * @throws ArtistNotFoundException given artist name not found
     */
    void addEvent(String eventName, String artistName, String description, LocalDate date, int availableTickets, int price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException;
    
    /**
     * Adds new festival type event to the collection
     * @param eventName event's name
     * @param description event's description
     * @param alignment artists alignment according with the date to perform
     * @param startDate festival start date
     * @param tickets available tickets for each day
     * @param price price according the number of day the ticket gives access to
     * @throws InvalidPrivilegeException current user logged in is not an Administrator
     * @throws EventAlreadyExistsException the event already exists in the collection
     * @throws ArtistNotFoundException ArtistNotFoundException given artist name not found
     */
    void addEvent(String eventName, String description, LocalDate startDate,  String[][] aligment, int tickets, int[] price) throws InvalidPrivilegeException, EventAlreadyExistsException, ArtistNotFoundException;
   
    //////////////////////////CLIENT
    
    /**
     * Buys ticket for a concert event
     * @param eventName event's name
     * @param startDate event's date
     * @param ticketCount number of thickets to buy
     * @throws InvalidPrivilegeException current user logged in is not a client
     * @throws EventNotFoundException event name not found in the collection
     * @throws EventSoldOutException event has less available tickets than the ticketCount amount supplied
     */
    int buyTicket(String eventName, LocalDate startDate, int ticketCount) throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException;
    
    /**
     * Buys ticket for a festival event
     * @param eventName event's name
     * @param startDate event's start date
     * @param dates string array with the dates of the event client wishes to go
     * @throws InvalidPrivilegeException current user logged in is not a client
     * @throws EventNotFoundException event name not found in the collection
     * @throws EventSoldOutException one or more dates of the event has sold out
     */
    int buyTicket(String eventName, LocalDate startDate, LocalDate[] dates) throws InvalidPrivilegeException, EventNotFoundException, EventSoldOutException;
    
    /**
     * Lists all tickets owned by a specific user. 
     * Tickets will be ordered by purchase date, from oldest to most recent.
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
     * @throws AnotherUserLoggedInException can't log in because other user is already logged in
     * @throws WrongPasswordException wrong password 
     */
    void logIn(String email, String password) throws UserNotFoundException, UserAlreadyLoggedInException, AnotherUserLoggedInException, WrongPasswordException;
    
    /**
     * Logs out the current logged user
     * @return email of user to be logged out
     * @throws LogoutException if no one is logged in
     */
    String logOut() throws LogoutException;


    /////////////////// ALL USERS
    
    /**
     * Registers new user to the system
     * @param type type of use to register ADMIN or CLIENT
     * @param email user email
     * @return generated password for the new user
     * @throws AnotherUserLoggedInException can't perform the operation because other user is already logged in
     * @throws UserAlreadyExistsException email supplied already exists in the collection
     */
    String register(USER_TYPE type, String email) throws AnotherUserLoggedInException, UserAlreadyExistsException;

    /**
     * Lists all events in the system
     * @return iterator containing all events in the collection
     */
    Iterator<Event> listAllEvents();
    
    /**
     * Lists all events in the system
     * Ordered from most to least sales, in case of a tie, closest date to current time comes first, if persists they're listed alphabetically
     * @return iterator containing all ordered events in the collection
     */
    Iterator<Event> listMostSold();
    
    /**
     * To list events from a specific type
     * @param type to be listed CONCERT or FESTIVAL
     * @return iterator containing all events of a given type
     * @throws UnknownEventTypeException if type is an unknown string
     */
    Iterator<Event> listEventsByType(String type) throws UnknownEventTypeException;
    
    /**
     * To list a specific event information
     * @param eventName event's name
     * @param date event's date or start date in case of festival
     * @return event of the given name and date identification
     * @throws EventNotFoundException if event doesn't exist in collection
     */
    Event listEventData(String eventName, LocalDate date) throws EventNotFoundException;
    
    /**
     * List events in where an artist will perform
     * @param artistName artist's name
     * @return custom iterator containing all events where the given artist will perform
     */
    ArtistEventIterator searchEventsWithArtist(String artistName) throws ArtistNotFoundException;// no enunciado nao diz o que acontece quando alguma coisa corre mal mas deve throwar um artistnotfoundexception
    
    
    //////////////////// MISC
    

}
