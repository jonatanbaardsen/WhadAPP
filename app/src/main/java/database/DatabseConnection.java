package database;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Windows10 on 10/19/2017.
 */

public class DatabseConnection
{
    public FirebaseDatabase GetConnection()
    {
        return FirebaseDatabase.getInstance();
    }
/*
    public Object AddObject(Object object)
    {
        return Object;
    }
    */
}
