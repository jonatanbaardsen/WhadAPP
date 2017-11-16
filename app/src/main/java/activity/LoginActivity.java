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

import model.Login;
import model.TestData;

public class LoginActivity extends BaseActivity implements View.OnClickListener
{

    private static final String TAG = "LoginActivity";
    Button buttonLogin;
    Button buttonRegister;
    ImageView imageLogoLogin;
    EditText textViewEmail;
    EditText textViewPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
/*
        if(userIsLoggedIn())
        {

        }
*/
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
            Toast.makeText(LoginActivity.this, "Both email and password must be entered",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (view.equals(buttonLogin))
        {
            login(email, password);
        }
        if (view.equals(buttonRegister))
        {
            register(email, password);
        }

        //  AsyncTask task = new AsyncTask();
        //  task.doInBackground(new Object[2]);


    }

    private void login(String email, String password)
    {
        getAuth().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(LoginActivity.this, "Logged in.",
                                    Toast.LENGTH_SHORT).show();
                            setUserLoggedIn(getAuth().getCurrentUser());
                            moveToMainPage();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void register(final String email, final String password)
    {
        getAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            login(email,password);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private void moveToMainPage()
    {
        Intent intent = new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }

    /* public class AsyncTask extends android.os.AsyncTask
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
*/
}
