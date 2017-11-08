package database;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import model.Chat;
import model.Contact;
import model.ContactRequest;
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
                Log.d("db", "Data could not be saved: " + databaseError.getMessage());
            }
            else
            {
                Log.d("db", "Data saved successfully.");
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

    private Query getSentContactRequestJsonList(String userId)
    {
        return null;//getDatabaseReference("contactRequest").getKey("")
    }

    private Query getRecievedContactRequestJsonList(String userId)
    {
        return null;
    }

    private Query getChatJsonList(String userId, int numberOfChats)
    {
        return getDatabaseReference("chat").limitToFirst(numberOfChats);
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

        getDatabaseReference(userId).child(chatId + "/messages").limitToLast(numberOfMessages);

        return null;

    }

    private Query getChatMessageJson(String userId, String chatId, String messageId)
    {
        return getDatabaseReference(userId).child(chatId + "/messages").child("messageId").equalTo(messageId);
    }


    public void addChatToDb(String userId, Chat chat)
    {

        getDatabaseReference("chat/" + chat.getChatId()).setValue(chat, completeListener);
/*
        for (FirebaseUser user : chat.getParticipants())
        {
            getDatabaseReference("user").equalTo(user.getUid());
        }
        */
        getDatabaseReference(userId).setValue(chat.getChatId(), completeListener);
    }

    public void addChatMessageToDb(String userId, Message message)
    {
        getDatabaseReference("message/" + message.getChatId()).push().setValue(message, completeListener);
        getDatabaseReference("chat/" + message.getChatId() + "/messages").push().setValue(message.getMessageId(), completeListener);
        getDatabaseReference(userId).child("chat/" + message.getChatId()).push().setValue(message.getMessageId(), completeListener);
    }


    public void addContactToDb(String userId, Contact contact)
    {
        String uniqueId = determineContactId(userId, contact.getUser().getUniqueID());
        getDatabaseReference("contact/" + uniqueId).setValue(contact, completeListener);
        getDatabaseReference(userId).child("contacts").push().setValue(contact.getUser().getUniqueID(), completeListener);
    }

    private String determineContactId(String userId, String uniqueID)
    {
        return userId.concat(uniqueID);
    }

    public void addContactRequest(String userId, ContactRequest request)
    {
        getDatabaseReference("contactRequest").push().setValue(request, completeListener);
    }


    public void addUserToDb(User user)
    {
        getDatabaseReference().child("User/" + user.getUniqueID()).setValue(user,
                completeListener);
    }

    public void updateUserToken(String userId, String refreshedToken)
    {
        getDatabaseReference(userId).child("fcmToken").setValue(refreshedToken, completeListener);

    }

    // TODO: 10/24/2017 Test and complete logic 

}
