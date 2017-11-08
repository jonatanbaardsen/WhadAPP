package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import database.DatabaseHandler;

/**
 * Created by Windows10 on 11/8/2017.
 */

public class TestData
{
    private DatabaseHandler db = new DatabaseHandler();
    public User user1;
    public User user2;
    public Chat chat;
    public Message message1;
    public Message message2;
    public Message message3;
    public ContactRequest contactRequest;

    public ContactRequest contactRequest2;

    public Contact contact;
    public Contact contact2;
    public String newToken;
    private Date today = new Date(System.currentTimeMillis());
    private static Map<String, String> myMap = createMap();

    private static Map<String, String> createMap()
    {
        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("chatId", "hello2");
        return myMap;
    }


    public TestData()
    {
        newToken = "jghfds";
        user1 = new User(null);
        user1.setUniqueID("1");
        user1.setFullName("Akhmed");
        user1.setFcmToken("oldToken");
        user2 = new User(null);
        user2.setUniqueID("2");
        user2.setFullName("Ali");

        chat = new Chat(null, System.currentTimeMillis());
        chat.setChatId("hello2");

        contactRequest = new ContactRequest(user1, user2, today);
        contactRequest2 = new ContactRequest(user2,user1,today);
        message1 = new Message("1", user1.getUniqueID(), user2.getUniqueID(), myMap);
        message2 = new Message("2", user1.getUniqueID(), user2.getUniqueID(), myMap);
        message3 = new Message("3",user2.getUniqueID(),user1.getUniqueID(),myMap);
        contact = new Contact(user2);
        contact2 = new Contact(user1);
    }

    public void saveData()
    {
        db.addUserToDb(user1);
        db.addUserToDb(user2);
       db.addContactToDb(user1.getUniqueID(),contact);
        db.addContactToDb(user2.getUniqueID(),contact2);
        db.addChatToDb(user1.getUniqueID(),chat);
        db.addChatToDb(user2.getUniqueID(),chat);
        db.addChatMessageToDb(user1.getUniqueID(),message1);
        db.addChatMessageToDb(user1.getUniqueID(),message2);
        db.addChatMessageToDb(user2.getUniqueID(),message3);
        db.addContactRequest(user1.getUniqueID(),contactRequest);
        db.addContactRequest(user2.getUniqueID(),contactRequest2);

    }


}
