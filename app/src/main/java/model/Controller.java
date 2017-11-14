package model;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;

import database.DatabaseHandler;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class Controller extends Application
{
    private final FirebaseAuth mAuth;
    private final FirebaseAuth.AuthStateListener mAuthListener;
    private String fcmToken;
    private FirebaseUser userLoggedIn;
    private User currentUser = null;



    private boolean loggedIn = false;
    private DatabaseHandler db = new DatabaseHandler();



    public Controller()
    {
        mAuth = FirebaseAuth.getInstance();

        //Creates a listener for a login-attempt
        mAuthListener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null)
                {
                    setUserLoggedIn(user);
                    setLoggedIn(true);
                }
                else
                {
                    setLoggedIn(false);
                }
            }
        };

        /*TODO Get chats to test main page
         */
    }

    /*public Task<GetTokenResult> getFirebaseFcmToken()
    {
        return userLoggedIn.getToken();
    }
*/
    public void setFirebaseFcmToken(String firebaseFcmToken)
    {
        this.fcmToken = firebaseFcmToken;
    }
    public FirebaseUser getUserLoggedIn()
    {
        return userLoggedIn;
    }

    public void setUserLoggedIn(FirebaseUser userLoggedIn)
    {
        this.userLoggedIn = userLoggedIn;
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }

    public boolean isLoggedIn()
    {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn)
    {
        this.loggedIn = loggedIn;
    }



/*
    public ArrayList<Integer> GetChatIdentifiers(String userToken)
    {
        return GetChatIdentifiers(0,userToken);
    }

    public ArrayList<Integer> GetChatIdentifiers(int numberOfChats,String userToken)
    {
        ArrayList<Chat> chats = new ArrayList<Chat>();
        if(numberOfChats == 0)
        {
            return null;
        }
        // TODO: 10/11/2017 Get Chat Identifiers
        return null;
    }

    public Chat GetChatByID(int id)
    {
        // TODO: 10/11/2017 Get Chats
        return null;
    }

    public ArrayList<Integer> GetMessageIdentifiersForChat(Chat chat)
    {
        // TODO: 10/11/2017 Get Message identifiers
        return null;
    }

    public Message GetMessageByID(int id)
    {
        // TODO: 10/11/2017 Get Message by ID
        return null;
    }

    public ArrayList<Integer> GetContactIdentifierForUser(User user)
    {
        // TODO: 10/11/2017 Get Contact
        return null;
    }
*/


}
