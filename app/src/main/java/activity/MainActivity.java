package activity;

import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;


import com.example.windows10.app.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ChatAdapter;
import database.DatabaseHandler;
import model.Chat;

public class MainActivity extends BaseActivity
{
Spinner spinnerMenuMain;
    GridView gridViewChatList;
    FloatingActionButton buttonNewChat;
    ImageView imageMainLogo;
    Toolbar toolbarMain;
    DatabaseHandler db = new DatabaseHandler();
    List<Chat> chats = new ArrayList<Chat>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridViewChatList = (GridView) findViewById(R.id.gridView_ActiveChats);
        buttonNewChat = (FloatingActionButton) findViewById(R.id.button_AddChat);
        imageMainLogo = (ImageView) findViewById(R.id.imageView_MainLogo);
        toolbarMain = (Toolbar) findViewById(R.id.toolbar_mainMenu);
        toolbarMain.setTitle("My chats");

        spinnerMenuMain = (Spinner) findViewById(R.id.spinner_mainMenu);
        //setSupportActionBar(toolbarMain);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    /*
        Update user details in activity
         */
    @Override
    public void updateUserDetails()
    {
// TODO: 10/13/2017 Update User Details
    }

    private void isUserSignedIn()
    {
        // TODO: 10/13/2017 Navigate to login 
    }
}
