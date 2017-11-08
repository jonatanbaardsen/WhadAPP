package model;

import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Set;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class FileMessage extends Message {
    public FileMessage(String messageId, long sentTime, String to, int title, Map<String, String> data, String from, RemoteMessage.Notification notification, String messageType, String collapseKey, Set<Map.Entry<String, String>> customData)
    {
        super(messageId, sentTime, to, title, data, from, notification, messageType, collapseKey, customData);
    }
}
