package model;
import java.util.Date;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class Login {

    private Date loggedIn;
    private User userLoggedIn;

    public Login(Date loggedIn, User userLoggedIn) {
        this.loggedIn = loggedIn;
        this.userLoggedIn = userLoggedIn;
    }

    public Date getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Date loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(User userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }






}
