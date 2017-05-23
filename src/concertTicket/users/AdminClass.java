
package concertTicket.users;

/**
 *
 * @author Joao Monteiro
 */
public class AdminClass extends UserClass implements Admin{

    public AdminClass(String email, String password) {
        super(email, password);
    }

}
