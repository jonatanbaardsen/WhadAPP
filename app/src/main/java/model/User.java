
package model;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.internal.zzbjp;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class User
{

    private String uniqueID;
    private String fullName;
    private String email;


    private String fcmToken;
    private Uri photoUrl;
    private boolean verified;
    private Date dateRegistered, dateVerified;
    private boolean deleteMe = false, freezeMe = false;
    private ArrayList<ContactRequest> sentContactRequests = new ArrayList<ContactRequest>();
    private ArrayList<ContactRequest> receivedContactRequests = new ArrayList<ContactRequest>();

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public String getUniqueID()
    {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID)
    {
        this.uniqueID = uniqueID;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Uri getPhotoUrl()
    {
        return photoUrl;
    }

    public void setPhotoUrl(Uri photoUrl)
    {
        this.photoUrl = photoUrl;
    }

    public boolean isVerified()
    {
        return verified;
    }

    public void setVerified(boolean verified)
    {
        this.verified = verified;
    }

    public Date getDateRegistered()
    {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered)
    {
        this.dateRegistered = dateRegistered;
    }

    public Date getDateVerified()
    {
        return dateVerified;
    }

    public void setDateVerified(Date dateVerified)
    {
        this.dateVerified = dateVerified;
    }

    public boolean isDeleteMe()
    {
        return deleteMe;
    }

    public void setDeleteMe(boolean deleteMe)
    {
        this.deleteMe = deleteMe;
    }

    public boolean isFreezeMe()
    {
        return freezeMe;
    }

    public void setFreezeMe(boolean freezeMe)
    {
        this.freezeMe = freezeMe;
    }

    public void setSentContactRequests(ArrayList<ContactRequest> sentContactRequests)
    {
        this.sentContactRequests = sentContactRequests;
    }

    public void setReceivedContactRequests(ArrayList<ContactRequest> receivedContactRequests)
    {
        this.receivedContactRequests = receivedContactRequests;
    }

    public void setContacts(ArrayList<Contact> contacts)
    {
        this.contacts = contacts;
    }

    public User(FirebaseUser user)
    {
        uniqueID = user.getUid();
        fullName = user.getDisplayName();
        email = user.getEmail();

        verified = user.isEmailVerified();
    }

    public ArrayList<Contact> getContacts()
    {
        return contacts;
    }

    public ArrayList<ContactRequest> getSentContactRequests()
    {
        return sentContactRequests;
    }

    public ArrayList<ContactRequest> getReceivedContactRequests()
    {
        return receivedContactRequests;
    }

    public String getFcmToken()
    {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken)
    {
        this.fcmToken = fcmToken;
    }

}