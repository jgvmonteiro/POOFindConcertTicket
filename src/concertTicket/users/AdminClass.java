
package concertTicket.users;

/**
 *
 * @author Joao Monteiro 51105, Diogo Tavares 50309
 */
public class AdminClass extends UserClass implements Admin{

   public static int adminCount=0;

   /**
    * 
    * @param email account email
    * @param password account password
    */
    public AdminClass(String email, String password) {
        super(email, password);
        adminCount++;
    }

}
