
package concertTicker.users;

/**
 *
 * @author Joao Monteiro
 */
public abstract class UserClass implements User{

    private String email;
    private String password;
    
    public UserClass(String email, String password) {
        this.email = email;
        this.password = password;
    }
   
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    

}
