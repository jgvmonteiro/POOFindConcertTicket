
package concertTicket.users;

/**
 * Users can log in, register and check the event information in 
 * the FindConcertTicket application. Once they're logged in, they gain access to different functions.
 * Its subclasses are Client and Admin, which have different priviledges.
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public interface User {
    
	/**
	 * Get method for the user's email
	 * @return email, which is set in the constructor
	 */
    String getEmail();
    
    /**
     * Get method for the user's password
     * @return password, which is set in the constructor
     */
    String getPassword();

}
