package activity;

import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;


import com.example.windows10.app.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import adapter.ChatAdapter;
import database.DatabaseHandler;
import model.Chat;
import service.ImageService;

public class MainActivity extends BaseActivity
{
    Spinner spinnerMenuMain;
    GridView gridViewChatList;
    FloatingActionButton buttonNewChat;
    ImageView imageMainLogo;
    Toolbar toolbarMain;
    DatabaseHandler db = new DatabaseHandler();
    List<Chat> chats = new ArrayList<Chat>();
    List<Integer> chatIds = new ArrayList<>();

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
        ChatAdapter adapter = new ChatAdapter(this, R.layout.activity_main, chats.toArray());
        gridViewChatList.setAdapter(adapter);

    }

    private void setListenersForDb(String uniqueID)
    {
        Log.d("----------------","------------------" + uniqueID + "--------------------------");
        db.getChatIdentifiersJsonList(uniqueID, 10).addChildEventListener(new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                Log.d("sdasdasdasd","fsdfsdfsdfdsfssfsdf-----------------------------------");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s)
            {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot)
            {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }

    private void getActiveChats(String uniqueID)
    {

        getChatIdsFromDb(uniqueID);
    }

    private void getChatIdsFromDb(String uniqueID)
    {

    }

    private void getChatsFromDb()
    {
        getChatImages();
    }

    private void getChatImages()
    {
        // ImageService imageService = new ImageService(this).bindService();
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        setListenersForDb(getApplicationUser().getUniqueID());
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
