
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

public class User {

    private String uniqueID;
    private String fullName;
    private String email;
    private Uri photoUrl;
    private boolean verified;
    private Date registered;
    private Date dateVerified;
    private boolean deleteMe;
    private boolean freezeMe;
    private ArrayList<ContactRequest> sentContactRequests = new ArrayList<ContactRequest>();
    private ArrayList<ContactRequest> receivedContactRequests = new ArrayList<ContactRequest>();


    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public User(FirebaseUser user)
    {
        uniqueID = user.getUid();
        fullName = user.getDisplayName();
        email = user.getEmail();
        verified = user.isEmailVerified();

    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public ArrayList<ContactRequest> getSentContactRequests() {
        return sentContactRequests;
    }

    public ArrayList<ContactRequest> getReceivedContactRequests() {
        return receivedContactRequests;
    }




}