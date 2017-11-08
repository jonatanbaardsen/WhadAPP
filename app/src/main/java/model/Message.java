package model;

import android.support.annotation.NonNull;

import com.google.firebase.messaging.RemoteMessage;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class Message
{

    private String messageId, toId, fromId, messageType, collapseKey;
    private long timeSent;
    private int title;
    private Map<String, String> data;
    private RemoteMessage.Notification notification;
    private boolean isRead = false;
    private String chatId;

    public Message(String messageId, long sentTime, String to, int title, Map<String, String> data, String from, RemoteMessage.Notification notification, String messageType, String collapseKey, Set<Map.Entry<String, String>> customData)
    {
        this.messageId = messageId;
        this.timeSent = sentTime;
        this.toId = to;
        this.title = title;
        this.data = data;
        this.fromId = from;
        this.notification = notification;
        this.messageType = messageType;
        this.collapseKey = collapseKey;

//Gets which chat this message belongs to
        for (Map.Entry<String, String> entry : customData)
            {
                if(entry.getKey().equals("chatId"))
                {
                    this.chatId = entry.getValue();
                }
            }
    }

    public Message(String messageId,String to,String from,Map<String,String> data)
    {
        this.messageId = messageId;
        this.timeSent = System.currentTimeMillis();
        this.toId = to;
        this.title = title;

        this.data = data;

        this.fromId = from;
        this.notification = null;
        this.messageType = null;
        this.collapseKey = null;

        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if(entry.getKey().equals("chatId"))
            {
                this.chatId = entry.getValue();
            }
        }
    }

    public String getMessageId()
    {
        return messageId;
    }

    public String getToId()
    {
        return toId;
    }

    public String getFromId()
    {
        return fromId;
    }

    public String getMessageType()
    {
        return messageType;
    }

    public String getCollapseKey()
    {
        return collapseKey;
    }

    public long getTimeSent()
    {
        return timeSent;
    }

    public int getTitle()
    {
        return title;
    }

    public Map<String, String> getData()
    {
        return data;
    }


    public boolean isRead()
    {
        return isRead;
    }

    public void setRead(boolean read)
    {
        isRead = read;
    }

    public String getChatId()
    {
        return chatId;
    }
}
