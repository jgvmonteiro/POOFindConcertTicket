import java.util.Scanner;

import concertTicker.*;
import concertTicker.exceptions.AnotherUserLoggedInException;
import concertTicker.exceptions.LogoutException;
import concertTicker.exceptions.UserAlreadyExistsException;
import concertTicker.exceptions.UserAlreadyLoggedInException;
import concertTicker.exceptions.UserNotFoundException;
import concertTicker.exceptions.WrongPasswordException;

/**
 *
 * @author ASUSLAPTOP
 */
public class Main {
    
	//user input
		//all users
	private static final String SHOWS = "SHOWS"; 
	private static final String SHOWS_BY_CLIENTS = "SHOWSBYCLIENTS";
	private static final String SHOWS_BY_TYPE = "SHOWSBYTYPE";
	private static final String SHOW = "SHOW";
	private static final String SEARCH = "SEARCH";
	private static final String REGISTER = "REGISTER";
	private static final String EXIT = "EXIT";
		//registered users
	private static final String LOGIN = "LOGIN";
	private static final String LOGOUT = "LOGOUT";
	
		//admins
	private static final String ADD_ARTIST = "ADDARTIST";
	private static final String ADD_SHOW = "ADDSHOW";
	
		//clients
	private static final String BUY_TICKET = "BUYTICKET";
	private static final String MY_TICKETS = "MYTICKETS";
	
	//system messages
	private static final String SYS_EXIST_MESSAGE = "Exiting.\n";
	private static final String SYS_ALL_SHOWS_LIST_HEADER = "All shows:\n";
	private static final String SYS_CONCERT_LIST_HEADER = "Concerts:\n";
	private static final String SYS_FESTIVALS_LIST_HEADER = "Festivals:\n";
	private static final String SYS_SHOW_INFO = "%s on %s\n";	//show name, show date
	private static final String SYS_ARTIST_SEARCH_CONCERTS = "Concerts of %s\n"; //artist name
	private static final String SYS_ARTIST_SEARCH_FESTIVALS = "Festivals where %s will play:\n"; //artist name
	private static final String SYS_USER_REGISTER_SUCCESS = "User was registered: %s\n\n"; //user password
	private static final String SYS_CONCERT_OR_FESTIVAL = "CONCERT OR FESTIVAL?\n";
	
	private static final String SYS_ARTIST_ADDED_SUCCESS = "Artist added.\n";
	private static final String SYS_SHOW_ADDED_SUCCESS = "Show added.\n";
	
	private static final String SYS_TICKET_BUY_SUCCESS = "Ticket bought with cost: %d"; //ticket price
	private static final String SYS_USER_TICKET_LIST = "My Tickets:\n";
	
	private static final String SYS_LOGIN_SUCCESS = "Welcome %s\n\n"; //user email
	private static final String SYS_LOGOUT_SUCCESS = "Goodbye %s\n\n"; //user email
	
	
    public static void main(String[] args){
       interpreter(); 
        
        
    }

	private static void interpreter() {
		Scanner in = new Scanner(System.in);
		FindConcertTicket fct = new FindConcertTicketClass();
		
		String option = in.next().toUpperCase();
		while(!option.equals(EXIT)){
			switch(option){
			case REGISTER:
				register(fct, in);
				break;
			case LOGIN:
				login(fct, in);
				break;
			case LOGOUT:
				logout(fct);
				
				default:
			}
			option = in.next().toUpperCase();
		}
		System.out.println(SYS_EXIST_MESSAGE);
	}
    
	private static void register(FindConcertTicket fct, Scanner in){
		
		String userType = in.next().toUpperCase();
		String email = in.next();
		String password;
		
		try {
			password = fct.register(userType, email);
			System.out.printf(SYS_USER_REGISTER_SUCCESS, password);
		} catch (UserAlreadyLoggedInException e) {
			System.out.println(e.getMessage());
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void login(FindConcertTicket fct, Scanner in){
		
		String email = in.next();
		String pword = in.next();
		
		try {
			fct.logIn(email, pword);
			System.out.printf(SYS_LOGIN_SUCCESS, email);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (UserAlreadyLoggedInException e) {
			System.out.println(e.getMessage());;
		} catch (AnotherUserLoggedInException e) {
			System.out.println(e.getMessage());
		} catch (WrongPasswordException e) {
			System.out.println(e.getMessage());
		}
	}
	
    private static void logout(FindConcertTicket fct){
    	try {
			String email = fct.logOut();
			System.out.printf(SYS_LOGOUT_SUCCESS, email);
		} catch (LogoutException e) {
			System.out.println(e.getMessage());
		}
    }

    
    
    
}
