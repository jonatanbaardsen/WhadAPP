package service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Windows10 on 10/12/2017.
 */

public class MessageService extends FirebaseMessagingService
{


    @Override
    public void onCreate()
    {
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
}
