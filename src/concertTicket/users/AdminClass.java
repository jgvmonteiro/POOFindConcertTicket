
package concertTicket.users;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class AdminClass extends UserClass implements Admin{

    public AdminClass(String email, String password) {
        super(email, password);
    }

}
