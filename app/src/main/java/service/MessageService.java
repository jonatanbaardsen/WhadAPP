package service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import database.DatabaseHandler;
import model.Controller;
import model.Message;

/**
 * Created by Windows10 on 10/12/2017.
 */

public class MessageService extends FirebaseMessagingService
{

    private DatabaseHandler database;
    private Controller controller;

    @Override
    public void onCreate()
    {
        database = new DatabaseHandler();
        controller = (Controller) getApplication();
        super.onCreate();

    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        return super.onUnbind(intent);
    }

    public String GetCurrentRegistrationToken()
    {
        return FirebaseInstanceId.getInstance().getToken();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        if (remoteMessage == null)
        {
            Log.d("Remote", "Remotemessage null");
            return;
        }
        Message message = new Message(remoteMessage.getMessageId(), remoteMessage.getSentTime(), remoteMessage.getTo(), remoteMessage.getTtl(), remoteMessage.getData(), remoteMessage.getFrom(), remoteMessage.getNotification(), remoteMessage.getMessageType(), remoteMessage.getCollapseKey(), remoteMessage.getData().entrySet());

        database.addMessageToDb(message);

        Log.d("messageservice", "message added to chat hello");

        super.onMessageReceived(remoteMessage);
    }

    @Override
    public void onMessageSent(String s)
    {
        super.onMessageSent(s);
    }

    @Override
    public void onSendError(String s, Exception e)
    {
        super.onSendError(s, e);
    }

    @Override
    public void onDeletedMessages()
    {
        super.onDeletedMessages();
    }


    public void SendMessage(String fromId, String toId)
    {

       //FirebaseMessaging.getInstance().send(new RemoteMessage());
    }
}
