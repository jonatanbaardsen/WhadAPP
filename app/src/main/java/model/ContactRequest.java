package model;

import java.util.Date;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class ContactRequest
{
    private User sentFrom;
    private User sentTo;
    private Date dateSent;
    private Date dateAnswered;
    private Boolean accepted;


    public ContactRequest()
    {
        this(null,null,null,null,false);
    }

    public ContactRequest(User sentFrom, User sentTo)
    {
        this(sentFrom, sentTo, null, null, false);
    }

    public ContactRequest(User sentFrom, User sentTo, Date dateSent)
    {
        this(sentFrom, sentTo, dateSent, null, false);
    }

    public ContactRequest(User sentFrom, User sentTo, Date dateSent, Date dateAnswered)
    {
        this(sentFrom, sentTo, dateSent, dateAnswered, false);
    }

    public ContactRequest(User sentFrom, User sentTo, Date dateSent, Date dateAnswered, Boolean accepted)
    {
        this.sentFrom = sentFrom;
        this.sentTo = sentTo;
        this.dateSent = dateSent;
        this.dateAnswered = dateAnswered;
        this.accepted = accepted;
    }

    public User getSentFrom()
    {
        return sentFrom;
    }

    public void setSentFrom(User sentFrom)
    {
        this.sentFrom = sentFrom;
    }

    public User getSentTo()
    {
        return sentTo;
    }

    public void setSentTo(User sentTo)
    {
        this.sentTo = sentTo;
    }

    public Date getDateSent()
    {
        return dateSent;
    }

    public void setDateSent(Date dateSent)
    {
        this.dateSent = dateSent;
    }

    public Date getDateAnswered()
    {
        return dateAnswered;
    }

    public void setDateAnswered(Date dateAnswered)
    {
        this.dateAnswered = dateAnswered;
    }

    public Boolean getAccepted()
    {
        return accepted;
    }

    public void setAccepted(Boolean accepted)
    {
        this.accepted = accepted;
    }


}
