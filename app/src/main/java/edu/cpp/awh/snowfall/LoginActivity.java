package edu.cpp.awh.snowfall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import edu.cpp.awh.snowfall.Util.Logging;

public class LoginActivity extends AppCompatActivity implements UI{

    EditText usernameEditText;
    EditText passwordEditText;
    Button registerButton;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Logging.TAG_LOGIN_ACTIVITY, Logging.DEBUG_LAUNCH_ACTIVITY + this.getClass().getSimpleName());
        setContentView(R.layout.activity_login);

        setUpUI();



    }

    public void setUpUI() {
        usernameEditText = (EditText) findViewById(R.id.login_userName);
        passwordEditText = (EditText) findViewById(R.id.login_password_edit_text);

        registerButton = (Button) findViewById(R.id.login_register_button);
        loginButton = (Button) findViewById(R.id.login_register_button);
    }
}
