package model;

import java.util.ArrayList;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class Chat
{
    private User createdBy;
    private String chatId = null;
    private Long timeCreated;
    private ArrayList<User> participants;
    private int countNewMessages;


    public Chat(User createdBy, long timeCreated)
    {

        this.createdBy = createdBy;
        this.timeCreated = timeCreated;
        participants = new ArrayList<User>();

        if(createdBy != null)
        participants.add(createdBy);
    }

    public User getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(User createdBy)
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

    public ArrayList<User> getParticipants()
    {
        return participants;
    }

    public void setParticipants(ArrayList<User> participants)
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
