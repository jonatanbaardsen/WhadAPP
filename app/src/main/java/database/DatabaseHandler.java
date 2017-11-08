package database;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import model.Chat;
import model.Contact;
import model.Message;
import model.User;

/**
 * Created by Windows10 on 10/19/2017.
 */

public class DatabaseHandler
{
    final private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference.CompletionListener completeListener = new DatabaseReference.CompletionListener()
    {
        @Override
        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference)
        {
            if (databaseError != null)
            {
                Log.d("db","Data could not be saved: " + databaseError.getMessage());
            }
            else
            {
                Log.d("db","Data saved successfully.");
            }
        }
    };

    private DatabaseReference getDatabaseReference()
    {
        return database.getReference("server/saving-data/whadapp");
    }

    private DatabaseReference getDatabaseReference(String child)
    {
        return database.getReference("server/saving-data/whadapp/" + child);
    }

    private Query getChatJsonList(String userId, int numberOfChats)
    {
        return getDatabaseReference(userId).child("chat").limitToFirst(numberOfChats);
    }

    private Query getContactJsonList(String userId, int numberOfContacts)
    {
        return getDatabaseReference(userId).child("contact").limitToFirst(numberOfContacts);
    }

    private Query getUserJsonList(int numberOfUsers)
    {
        return getDatabaseReference().child("user").limitToFirst(numberOfUsers);
    }

    private Query getChatMessagesJsonList(String userId, String chatId, int numberOfMessages)
    {
        return getDatabaseReference(userId).child(chatId).limitToLast(numberOfMessages);
    }

    private Query getChatMessageJson(String userId, String chatId, String messageId)
    {
        return getDatabaseReference(userId).child(chatId + "/messages").child("messageId").equalTo(messageId);
    }


    public void addChatToDb(String userId,Chat chat)
    {
        getDatabaseReference(userId + "/chat/" + chat.getChatId()).setValue(chat, completeListener);
    }

    public void addMessageToDb(String userId,Message message)
    {
        getDatabaseReference(userId).child( "chat/" + message.getChatId()).push().setValue(message, completeListener);
    }


    public void addContactToDb(String userId,Contact contact)
    {
       getDatabaseReference(userId).child(contact.getUser().getUniqueID()).setValue(contact,completeListener);
    }

    public void addUserToDb(User user)
    {
        getDatabaseReference().child("User/" + user.getUniqueID()).setValue(user,
                completeListener);
    }

    public void updateUserToken(String userId,String refreshedToken)
    {
        getDatabaseReference(userId).child("fcmToken").setValue(refreshedToken,completeListener);

    }

    // TODO: 10/24/2017 Test and complete logic 

}
