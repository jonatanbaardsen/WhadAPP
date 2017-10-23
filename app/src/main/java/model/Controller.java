package model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class Controller extends Application
{

    public Controller()
    {

    }

    public ArrayList<Integer> GetChatIdentifiers(String userToken)
    {
        return GetChatIdentifiers(0,userToken);
    }

    public ArrayList<Integer> GetChatIdentifiers(int numberOfChats,String userToken)
    {
        ArrayList<Chat> chats = new ArrayList<Chat>();
        if(numberOfChats == 0)
        {
            return null;
        }
        // TODO: 10/11/2017 Get Chat Identifiers
        return null;
    }

    public Chat GetChatByID(int id)
    {
        // TODO: 10/11/2017 Get Chats
        return null;
    }

    public ArrayList<Integer> GetMessageIdentifiersForChat(Chat chat)
    {
        // TODO: 10/11/2017 Get Message identifiers
        return null;
    }

    public Message GetMessageByID(int id)
    {
        // TODO: 10/11/2017 Get Message by ID
        return null;
    }

    public ArrayList<Integer> GetContactIdentifierForUser(User user)
    {
        // TODO: 10/11/2017 Get Contact
        return null;
    }

}
