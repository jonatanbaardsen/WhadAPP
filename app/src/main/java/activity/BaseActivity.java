package activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import model.Controller;

/**
 * Created by Windows10 on 10/12/2017.
 */

public abstract class BaseActivity extends AppCompatActivity
{


    //The Firebase Authenticator instance
    private FirebaseAuth mAuth;
    //A listener for the Authenticator
    private FirebaseAuth.AuthStateListener mAuthListener;
    //The Firebase User
    private FirebaseUser userLoggedIn = null;
    private boolean loggedIn = false;

    //Gets the controller for all activities


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Gets instance of the Firebase Authenticator
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
                    userLoggedIn = user;
                    loggedIn = true;
                }
                else
                {
                    loggedIn = false;
                }
            }
        };
    }




    @Override
    protected void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        Controller controller = (Controller) getApplicationContext();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if (mAuthListener != null)
        {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    /*
    Updates user details in the activity
     */
    public abstract void updateUserDetails();


}