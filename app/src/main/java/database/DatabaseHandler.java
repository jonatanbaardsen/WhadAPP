package database;

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

    public Query getChatIdentifiersJsonList(String userId, int numberOfChats)
    {
        return getDatabaseReference(userId).child("chat").limitToFirst(numberOfChats);
    }

    public Query getContactIdentifiersJsonList(String userId, int numberOfContacts)
    {
        return getDatabaseReference(userId).child("contact").limitToFirst(numberOfContacts);
    }

    public Query getUserJsonList(int numberOfUsers)
    {
        return getDatabaseReference().child("user").limitToFirst(numberOfUsers);
    }

    public Query getChatMessagesJsonList(String userId, String chatId, int numberOfMessages)
    {
        return getDatabaseReference(userId).child(chatId + "/messages").limitToLast(numberOfMessages);
    }


   public Query getContactRequestsJsonList(String userId)
    {
    return getDatabaseReference("contactRequest/");
    }


    public void addChatToDb(String userId,Chat chat)
    {
        getDatabaseReference("chat/" + chat.getChatId()).setValue(chat, completeListener);
        getDatabaseReference(userId).child("chat").push().setValue(chat.getChatId(),completeListener);
    }

    public void addChatMessageToDb(String userId, Message message)
    {
        getDatabaseReference(userId).child( "chat/" + message.getChatId() + "/messages").push().setValue(message, completeListener);
    }


    public void addContactToDb(String userId,Contact contact)
    {
       getDatabaseReference("contacts/" + contact.getUser().getUniqueID()).setValue(contact,completeListener);
       getDatabaseReference(userId).child("contacts/").push().setValue(contact.getUser().getUniqueID(),completeListener);

    }

    public void addUserToDb(User user)
    {
        getDatabaseReference().child("user/" + user.getUniqueID()).setValue(user,
                completeListener);
    }

    public void updateUserToken(String userId,String refreshedToken)
    {
        getDatabaseReference("user/" + userId).child("fcmToken").setValue(refreshedToken,completeListener);

    }

    public void addContactRequest(ContactRequest contactRequest)
    {
        String newKey = getDatabaseReference("contactRequest").push().getKey();
        getDatabaseReference("contactRequest/" + newKey).setValue(contactRequest,completeListener);


        getDatabaseReference(contactRequest.getSentFrom()).child("sentRequests/").setValue(newKey,completeListener);
        getDatabaseReference(contactRequest.getSentTo()).child("receivedRequests/").setValue(newKey,completeListener);
    }

    // TODO: 10/24/2017 Test and complete logic
}
