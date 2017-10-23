package model;

import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Windows10 on 10/11/2017.
 */

public class Chat {
    private FirebaseUser createdBy;
    private Date created;
    private ArrayList<FirebaseUser> participants;
    private int countNewMessages;

    public Chat(FirebaseUser createdBy, Date created) {
        this.createdBy = createdBy;
        this.created = created;
        participants = new ArrayList<FirebaseUser>();
    }
}
