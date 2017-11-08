package activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.windows10.app.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener
{

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

        if(userIsLoggedIn())
        {
            Intent intent = new Intent(this,MainActivity.class);
            finish();
            startActivity(intent);
        }

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

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
            System.out.println("Login---------------------");

        if (view.equals(buttonLogin))
        {
            System.out.println("Login---------------------");


        }
        if (!view.equals(buttonRegister))
        {


            System.out.println("Register-------");
        }

    }
}
