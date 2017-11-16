package database;

import android.text.TextUtils;
import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.*;

import model.Chat;
import model.Contact;
import model.ContactRequest;
import model.Controller;
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

    public Query getChatIdentifiersJsonList(String userId, int numberOfChats)
    {
        return getDatabaseReference(userId).child("chats").limitToFirst(numberOfChats);
    }

    public Query getContactIdentifiersJsonList(String userId, int numberOfContacts)
    {
        return getDatabaseReference(userId).child("contact").limitToFirst(numberOfContacts);
    }

    public Query getUsersJsonList()
    {
        return getDatabaseReference().child("user");
    }

    public Query getUserJson(String userId)
    {
        return getDatabaseReference("user").child(userId);
    }

    public Query getChatMessagesJsonList(String userId, String chatId, int numberOfMessages)
    {
        return getDatabaseReference(userId).child(chatId + "/messages").limitToLast(numberOfMessages);
    }


    public Query getContactRequestsJsonList(String userId)
    {
        return getDatabaseReference("contactRequest/");
    }


    public void addChatToDb(String userId, Chat chat)
    {
        if(TextUtils.isEmpty(chat.getChatId()))
            chat.setChatId(getDatabaseReference("chat").push().getKey());


        getDatabaseReference("chat/" + chat.getChatId()).setValue(chat, completeListener);
        getDatabaseReference(userId).child("chats").setValue(chat.getChatId(), completeListener);
    }

    public void addContactToChatInDb(Contact contact,Chat chat)
    {
        getDatabaseReference("chat/" + chat.getChatId()).child("participants").setValue(contact.getUniqueId(),completeListener);
        getDatabaseReference(contact.getUser().getUniqueID()).child("chats").setValue(chat.getChatId());
    }

    public void addChatMessageToDb(String userId, Message message)
    {
        getDatabaseReference("chat").child("messages/" + message.getMessageId()).setValue(message);
    }


    public void addContactToDb(String userId, Contact contact)
    {

        String newKey = getDatabaseReference(userId).child("contacts").push().getKey();
        contact.setUniqueId(newKey);
        getDatabaseReference("contact/" + newKey).setValue(contact, completeListener);
        getDatabaseReference(userId).child("contacts").setValue(contact.getUniqueId(), completeListener);

    }

    public void addUserToDb(User user)
    {
        getDatabaseReference().child("user/" + user.getUniqueID()).setValue(user,
                completeListener);
    }

    public void updateUserToken(String userId, String refreshedToken)
    {
        getDatabaseReference("user/" + userId).child("fcmToken").setValue(refreshedToken, completeListener);

    }

    public void addContactRequest(ContactRequest contactRequest)
    {
        String newKey = getDatabaseReference("contactRequest").push().getKey();
        getDatabaseReference("contactRequest/" + newKey).setValue(contactRequest, completeListener);


        getDatabaseReference(contactRequest.getSentFrom()).child("sentRequests/").setValue(newKey, completeListener);
        getDatabaseReference(contactRequest.getSentTo()).child("receivedRequests/").setValue(newKey, completeListener);
    }

}
