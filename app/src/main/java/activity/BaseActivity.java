package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import model.Controller;

/**
 * Created by Windows10 on 10/12/2017.
 */

public abstract class BaseActivity extends AppCompatActivity
{


    private Controller controller;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
controller = (Controller) getApplication();
        //Gets instance of the Firebase Authenticator
//if(controller.user)


    }




    @Override
    protected void onStart()
    {
        super.onStart();

        if(mAuth != null)
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


    public boolean userIsLoggedIn()
    {
        return loggedIn;
    }


    public FirebaseUser getUserLoggedIn()
    {
        return userLoggedIn;
    }

    public void setUserLoggedIn(FirebaseUser userLoggedIn)
    {
        this.userLoggedIn = userLoggedIn;
    }
}
