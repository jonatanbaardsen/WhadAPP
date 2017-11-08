package model;

import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class Chat
{
    private FirebaseUser createdBy;
    private String chatId;
    private Long timeCreated;
    private ArrayList<FirebaseUser> participants;
    private int countNewMessages;


    public Chat(FirebaseUser createdBy, long timeCreated)
    {
        this.createdBy = createdBy;
        this.timeCreated = timeCreated;
        participants = new ArrayList<FirebaseUser>();
        participants.add(createdBy);
    }

    public FirebaseUser getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(FirebaseUser createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getChatId()
    {
        return chatId;
    }

    public void setChatId(String chatId)
    {
        this.chatId = chatId;
    }

    public Long getTimeCreated()
    {
        return timeCreated;
    }

    public void setTimeCreated(Long timeCreated)
    {
        this.timeCreated = timeCreated;
    }

    public ArrayList<FirebaseUser> getParticipants()
    {
        return participants;
    }

    public void setParticipants(ArrayList<FirebaseUser> participants)
    {
        this.participants = participants;
    }

    public int getCountNewMessages()
    {
        return countNewMessages;
    }

    public void setCountNewMessages(int countNewMessages)
    {
        this.countNewMessages = countNewMessages;
    }
}
