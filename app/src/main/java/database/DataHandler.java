package database;

import java.util.ArrayList;
import java.util.List;

import model.*;

/**
 * Created by Windows10 on 11/14/2017.
 */

public class DataHandler
{
    private static User currentUser;
    private static List<User> users = new ArrayList<User>();
    private static List<Contact> contacts = new ArrayList<Contact>();
    private static List<Chat> chats = new ArrayList<Chat>();
    private static List<Message> chatMessages = new ArrayList<Message>();
    private static List<ContactRequest> incomingRequests = new ArrayList<ContactRequest>();
    private static List<ContactRequest> outgoingRequests = new ArrayList<ContactRequest>();

    public static List<User> getUsers()
    {
        return users;
    }

    public static List<Contact> getContacts()
    {
        return contacts;
    }

    public static List<Chat> getChats()
    {
        return chats;
    }

    public static List<Message> getChatMessages()
    {
        return chatMessages;
    }

    public static List<ContactRequest> getIncomingRequests()
    {
        return incomingRequests;
    }

    public static List<ContactRequest> getOutgoingRequests()
    {
        return outgoingRequests;
    }

    public static User getCurrentUser()
    {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser)
    {
        DataHandler.currentUser = currentUser;
    }





}
