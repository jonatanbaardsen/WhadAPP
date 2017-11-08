package service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import database.DatabaseHandler;
import model.Controller;

public class FirebaseTokenService extends FirebaseInstanceIdService
{
    private Controller controller;
    private DatabaseHandler databaseHandler;

    public FirebaseTokenService()
    {
        controller = (Controller) getApplication();
        databaseHandler = new DatabaseHandler();
    }

    @Override
    public void onTokenRefresh()
    {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
databaseHandler.updateUserToken("blabla",refreshedToken);

    }
}
