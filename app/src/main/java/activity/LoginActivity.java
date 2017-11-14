package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.windows10.app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseHandler;
import model.Controller;
import model.TestData;
import model.User;

public class LoginActivity extends BaseActivity implements View.OnClickListener
{

    private static final String TAG = "LoginActivity";
    Controller controller = (Controller) getApplication();
    Button buttonLogin;
    Button buttonRegister;
    ImageView imageLogoLogin;
    EditText textViewEmail;
    EditText textViewPassword;
    DatabaseHandler db = new DatabaseHandler();
    List<User> users = new ArrayList<>();

    boolean userExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);


        if (userIsLoggedIn())
        {
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        }


        //db.getUsersReference(0).addListenerForSingleValueEvent(usersListener);
    }


    @Override
    protected void onStart()
    {
        super.onStart();

        buttonLogin = (Button) findViewById(R.id.button_login);
        buttonRegister = (Button) findViewById(R.id.button_register);
        imageLogoLogin = (ImageView) findViewById(R.id.imageView_logoLogin);
        textViewEmail = (EditText) findViewById(R.id.text_email);
        textViewPassword = (EditText) findViewById(R.id.text_password);

        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);


    }

    /*
    Updates user details in activity
     */
    @Override
    public void updateUserDetails()
    {

    }


    private boolean registered(String email, String password)
    {
        return true;
    }

    @Override
    public void onClick(View view)
    {
        String email = textViewEmail.getText().toString().trim();
        String password = textViewPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
        {
            Toast.makeText(LoginActivity.this, "Fields must not be empty!",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,ProfileActivity.class);
            startActivity(intent);
            return;
        }

        if (view.equals(buttonLogin))
        {

            login(email,password);
        }
        if (view.equals(buttonRegister))
        {
            registerUser(email,password);
        }
    }

    public void registerUser(final String email, final String password)
    {
        getmAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = getmAuth().getCurrentUser();
                            setUserLoggedIn(user);
                            createAndSaveUser(user);
                            login(email, password);
                            moveToMainPage();
                        }
                        else
                        {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    public void login(String email, String password)
    {
        getmAuth().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = getmAuth().getCurrentUser();
                            setUserLoggedIn(user);
                            moveToMainPage();
                        }
                        else
                        {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void moveToMainPage()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void createAndSaveUser(FirebaseUser firebaseUser)
    {
        User user = new User(firebaseUser);
        db.addUserToDb(user);
        controller.setCurrentUser(user);
    }

    public class AsyncTask extends android.os.AsyncTask
    {

        @Override
        protected Object doInBackground(Object[] objects)
        {
            TestData testData = new TestData();
//testData.saveData();
            testData.getData();
            return null;
        }
    }

}
