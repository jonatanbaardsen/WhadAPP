package model;

import java.util.Date;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class Contact
{



    private String uniqueId;
    private User user;
    private Date requestSent;
    private Date added;
    private Date removed;


    public Contact()
    {
        this(null,null,null,null);
    }

    public Contact(User user)
    {
        this(user, null, null, null);
    }

    public Contact(User user, Date requestSent)
    {
        this(user, requestSent, null, null);
    }

    public Contact(User user, Date requestSent, Date added)
    {
        this(user, requestSent, added, null);
    }


    public Contact(User user, Date requestSent, Date added, Date removed)
    {
        this.user = user;
        this.requestSent = requestSent;
        this.added = added;
        this.removed = removed;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Date getRequestSent()
    {
        return requestSent;
    }

    public void setRequestSent(Date requestSent)
    {
        this.requestSent = requestSent;
    }

    public Date getAdded()
    {
        return added;
    }

    public void setAdded(Date added)
    {
        this.added = added;
    }

    public Date getRemoved()
    {
        return removed;
    }

    public void setRemoved(Date removed)
    {
        this.removed = removed;
    }

    public String getUniqueId()
    {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId)
    {
        this.uniqueId = uniqueId;
    }
}
