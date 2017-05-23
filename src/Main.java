
import concertTicket.FindConcertTicketClass;
import concertTicket.FindConcertTicket;
import java.util.Scanner;

import concertTicket.FindConcertTicket.*;
import concertTicket.event.Concert;
import concertTicket.event.Event;
import concertTicket.event.Festival;
import concertTicket.exceptions.AnotherUserLoggedInException;
import concertTicket.exceptions.ArtistAlreadyExistsException;
import concertTicket.exceptions.ArtistNotFoundException;
import concertTicket.exceptions.EventAlreadyExistsException;
import concertTicket.exceptions.EventNotFoundException;
import concertTicket.exceptions.EventSoldOutException;
import concertTicket.exceptions.InvalidPrivilegeException;
import concertTicket.exceptions.LogoutException;
import concertTicket.exceptions.UnknownEventTypeException;
import concertTicket.exceptions.UserAlreadyExistsException;
import concertTicket.exceptions.UserAlreadyLoggedInException;
import concertTicket.exceptions.UserNotFoundException;
import concertTicket.exceptions.WrongPasswordException;
import concertTicket.ticket.ConcertTicket;
import concertTicket.ticket.FestivalTicket;
import concertTicket.ticket.Ticket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUSLAPTOP
 */
public class Main {

    //user input
    //all users
    private static final String CMD_SHOWS = "SHOWS";
    private static final String CMD_SHOWS_BY_CLIENTS = "SHOWSBYCLIENTS";
    private static final String CMD_SHOWS_BY_TYPE = "SHOWSBYTYPE";
    private static final String CMD_SHOW = "SHOW";
    private static final String CMD_SEARCH = "SEARCH";
    private static final String CMD_REGISTER = "REGISTER";
    private static final String CMD_EXIT = "EXIT";
    //registered users
    private static final String CMD_LOGIN = "LOGIN";
    private static final String CMD_LOGOUT = "LOGOUT";
    //admins
    private static final String CMD_ADD_ARTIST = "ADDARTIST";
    private static final String CMD_ADD_SHOW = "ADDSHOW";
    //clients
    private static final String CMD_BUY_TICKET = "BUYTICKET";
    private static final String CMD_MY_TICKETS = "MYTICKETS";

    //other commands
    private static final String CMD_CONCERT = "CONCERT";
    private static final String CMD_ADMIN = "ADMIN";

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

    //Exceptions
    private static final String EX_ANOTHER_USER_LOGGED_IN = "Another user is logged in.\n";
    private static final String EX_ARTIST_ALREADY_EXISTS = "Artist name already exists.\n";
    private static final String EX_ARTIST_NOT_FOUND_SINGLE = "Artist name does not exist.\n";
    private static final String EX_ARTIST_NOT_FOUND_MULTIPLE = "Artist names do not exist.\n";
    private static final String EX_EVENT_ALREADY_EXISTS = "";
    private static final String EX_EVENT_NOT_FOUND = "Show does not exists.\n";
    private static final String EX_EVENT_SOLD_OUT = "There are not sufficient seats for the request.\n";
    private static final String EX_INVALID_PRIVILEGE = "User cannot execute this command.\n";
    private static final String EX_LOGOUT = "No user is logged in.\n";
    private static final String EX_UNKOWN_EVENT_TYPE = "Unknown type of show.\n";
    private static final String EX_USER_ALREADY_EXISTS = "User already exists.\n";
    private static final String EX_USER_ALREADY_LOGGED_IN = "User already logged in.\n";
    private static final String EX_USER_NOT_FOUND = "User does not exist.\n";
    private static final String EX_WRONG_PASSWORD = "Wrong password.\n";

    private static final String EX_UNKNOWN = "Unknown exception occured.\n";

    public static void main(String[] args) {
    	interpreter();
    }

    private static void interpreter() {
        Scanner in = new Scanner(System.in);
        FindConcertTicket fct = new FindConcertTicketClass();

        String option = in.nextLine().toUpperCase();
        while (!option.equals(CMD_EXIT)) {
            switch (option) {
                case CMD_REGISTER:
                    register(fct, in);
                    break;
                case CMD_LOGIN:
                    login(fct, in);
                    break;
                case CMD_LOGOUT:
                    logout(fct);
                    break;
                case CMD_ADD_ARTIST:
                    addArtist(fct, in);
                    break;
                case CMD_ADD_SHOW:
                    addEvent(fct, in);
                    break;
                case CMD_MY_TICKETS:
                    listTickets(fct, in);
                    break;
                case CMD_BUY_TICKET:
                    buyTicket(fct, in);
                    break;
                case CMD_SHOWS_BY_TYPE:
                    listByType(fct, in);
                    break;
                default:
            }
            option = in.nextLine().toUpperCase();
        }
        System.out.println(SYS_EXIST_MESSAGE);
    }

    private static void register(FindConcertTicket fct, Scanner in) {
        try {
            String typeStr = in.next().toUpperCase();
            String email = in.next();
            USER_TYPE type;
            if (typeStr.equals(CMD_ADMIN)) {
                type = USER_TYPE.ADMIN;
            } else {
                type = USER_TYPE.CLIENT;
            }
            String password = fct.register(type, email);
            System.out.printf(SYS_USER_REGISTER_SUCCESS, password);
        } catch (UserAlreadyLoggedInException e) {
            System.out.println(EX_USER_ALREADY_LOGGED_IN);
        } catch (UserAlreadyExistsException e) {
            System.out.println(EX_USER_ALREADY_EXISTS);
        }
    }

    private static void login(FindConcertTicket fct, Scanner in) {
        try {
            String email = in.nextLine();
            String password = in.nextLine();
            fct.logIn(email, password);
            System.out.printf(SYS_LOGIN_SUCCESS, email);
        } catch (UserNotFoundException e) {
            System.out.println(EX_USER_NOT_FOUND);
        } catch (UserAlreadyLoggedInException e) {
            System.out.println(EX_USER_ALREADY_LOGGED_IN);
        } catch (AnotherUserLoggedInException e) {
            System.out.println(EX_ANOTHER_USER_LOGGED_IN);
        } catch (WrongPasswordException e) {
            System.out.println(EX_WRONG_PASSWORD);
        }
    }

    private static void logout(FindConcertTicket fct) {
        try {
            String email = fct.logOut();
            System.out.printf(SYS_LOGOUT_SUCCESS, email);
        } catch (LogoutException e) {
            System.out.println(EX_LOGOUT);
        }
    }

    private static void addArtist(FindConcertTicket fct, Scanner in) {
        try {
            String name = in.nextLine();
            int n_albuns = Integer.parseInt(in.nextLine());
            String[] albuns = new String[n_albuns];
            for (int i = 0; i < n_albuns; i++) {
                albuns[i] = in.nextLine();
            }
            int n_elements = Integer.parseInt(in.nextLine());
            if (n_elements == 1) {
                fct.addArtist(name, albuns);
            } else {
                String[] elements = new String[n_elements];
                for (int i = 0; i < n_elements; i++) {
                    elements[i] = in.nextLine();
                }
                fct.addArtist(name, albuns, elements);
            }
            System.out.println(SYS_ARTIST_ADDED_SUCCESS);
        } catch (ArtistAlreadyExistsException e) {
            System.out.println(EX_ARTIST_ALREADY_EXISTS);
        } catch (InvalidPrivilegeException e) {
            System.out.println(EX_INVALID_PRIVILEGE);
        }
    }
    
    private static void addEvent(FindConcertTicket fct, Scanner in){     
        try{String name = in.nextLine();
        String desc = in.nextLine();
        int tickets = Integer.parseInt(in.nextLine());
        System.out.println(SYS_CONCERT_OR_FESTIVAL);
        String resp = in.nextLine();
        if(resp.equalsIgnoreCase(CMD_CONCERT)){
            String artist_name = in.nextLine();
            LocalDate date = LocalDate.parse(in.nextLine());
            int price = Integer.parseInt(in.nextLine());
            fct.addEvent(name, artist_name, desc, date,tickets, price);
       
        }else{
            int duration = Integer.parseInt(in.nextLine());
            LocalDate startDate = LocalDate.parse(in.nextLine());
            String[][] alignment = new String[duration][];
            for(int i=0; i<duration;i++){
                int n = Integer.parseInt(in.nextLine());
                String[] artists = new String[n];
                for(int j=0; j<n;j++){
                    artists[j] = in.nextLine();
                }
                alignment[i] = artists;
            }   
            int[] prices = new int[duration];
            for(int i=0; i<duration;i++){
                in.next();
                prices[i] = in.nextInt();
                in.nextLine();
            }
            fct.addEvent(name, desc, startDate, alignment, tickets, prices);
        }
        System.out.println(SYS_SHOW_ADDED_SUCCESS);
        }catch(ArtistNotFoundException e){
            handleArtistsNotFoundException(e);
        } catch (InvalidPrivilegeException e) {
            System.out.println(EX_INVALID_PRIVILEGE);
        } catch (EventAlreadyExistsException e) {
            System.out.println(EX_EVENT_ALREADY_EXISTS);
        }
    }
    
    private static void handleArtistsNotFoundException(ArtistNotFoundException e){ //ola
    	String[] list = e.getArtistList();
    	if(list.length == 1)
    		System.out.println(EX_ARTIST_NOT_FOUND_SINGLE);
    	else System.out.println(EX_ARTIST_NOT_FOUND_MULTIPLE);
    	
    	for(int i = 0; i < list.length; i++)
    		System.out.println(list[i]);
    }
    
    private static void buyTicket(FindConcertTicket fct, Scanner in){
        try{
        String name = in.nextLine();
        LocalDate date = LocalDate.parse(in.nextLine());
        System.out.println(SYS_CONCERT_OR_FESTIVAL);
        String resp = in.nextLine();
        if(resp.equalsIgnoreCase(CMD_CONCERT)){
            int n_tickets = Integer.parseInt(in.nextLine());
            fct.buyTicket(name, date, n_tickets);
        }else{
            int n_days = Integer.parseInt(in.nextLine());
            LocalDate[] dates = new LocalDate[n_days];
            for (int i = 0; i < n_days; i++) {
                dates[i] = LocalDate.parse(in.nextLine());
            }
            fct.buyTicket(name, date, dates);
        }
        }catch(EventNotFoundException e){
            System.out.println(EX_EVENT_NOT_FOUND);
        } catch (InvalidPrivilegeException e) {
            System.out.println(EX_INVALID_PRIVILEGE);
        } catch (EventSoldOutException e) {
            System.out.println(EX_EVENT_SOLD_OUT);
        }
        
    }

    
    private static void listTickets(FindConcertTicket fct, Scanner in){
        Iterator<Ticket> it = fct.listTickets();
        System.out.println("My Tickets:");
        while(it.hasNext()){
            Ticket ticket = it.next();
            if(ticket instanceof ConcertTicket){
                ConcertTicket ct = (ConcertTicket)ticket;
                System.out.println(ct.eventName());
                System.out.println(ct.startDate().toString());
                System.out.println(ct.numberTickets());
                System.out.println(ct.totalPrice());
            }else{
                FestivalTicket ft = (FestivalTicket)ticket;
                LocalDate[] dates = ft.dates();
                for(LocalDate date:dates)
                    System.out.println(date.toString());
                System.out.println(ft.totalPrice());
            }
        }    
    }

    private static void listAll(FindConcertTicket fct, Scanner in){
       
       System.out.println("All shows:");
       Iterator<Event> it = fct.listAllEvents();
       while(it.hasNext()){
           Event e = it.next();
           if(e instanceof ConcertTicket){
               Concert ce = (Concert)e;
               System.out.println(ce.name());
               System.out.println(ce.artist().getName());
               System.out.println(ce.date());
               System.out.println(ce.price());
               System.out.println(ce.availableTickets());      
           }else{
               Festival fe = (Festival)e; 
               System.out.println(fe.name());
               System.out.println(fe.startDate());
               
           
           }
       }
   }
    
    private static void listByType(FindConcertTicket fct, Scanner in) {
        try {
            String type = in.nextLine();
            if (type.equalsIgnoreCase(FindConcertTicket.EVENT_TYPE_CONCERT)) {
                Iterator<Event> it = fct.listEventsByType(type);
                Concert c = (Concert)it.next();
                System.out.println(c.name());
                System.out.println(c.artist());
                System.out.println(c.date().toString());
                System.out.println(c.price());
                System.out.println(c.availableTickets());
            } else {

            }
        } catch (UnknownEventTypeException e) {
            
        }
    }
    
  

}
