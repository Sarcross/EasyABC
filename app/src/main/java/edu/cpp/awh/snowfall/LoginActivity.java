package edu.cpp.awh.snowfall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.cpp.awh.snowfall.cryptography.Crypto;
import edu.cpp.awh.snowfall.util.Logging;

public class LoginActivity extends AppCompatActivity implements UI{

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Logging.TAG_LOGIN_ACTIVITY, Logging.DEBUG_LAUNCH_ACTIVITY);
        setContentView(R.layout.activity_login);

        setUpUI();
    }

    public void setUpUI() {
        usernameEditText = (EditText) findViewById(R.id.loginActivity_userName);
        passwordEditText = (EditText) findViewById(R.id.loginActivity_password_edit_text);

        registerButton = (Button) findViewById(R.id.loginActivity_register_button);
        loginButton = (Button) findViewById(R.id.loginActivity_login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tryLogin(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                //LoginActivity.this.tryLogin(usernameEditText.getText().toString(), Crypto.getHash(passwordEditText.getText().toString()));
                Toast.makeText(LoginActivity.this, "You have been registered.", Toast.LENGTH_LONG).show();
                finish();
                /*Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString("username", "test");
                b.putString("password", "test");
                startActivity(intent, b);*/
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!LoginActivity.this.verifyCredentials(usernameEditText.getText().toString(), Crypto.getHash(passwordEditText.getText().toString()))) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Bundle b = new Bundle();
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "You have been registered.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "This user already exists.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void tryLogin(String username, String pHash) {
        Intent intent = new Intent(this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("username", username);
        b.putString("password", pHash);
        startActivity(intent, b);
        this.finish();

        /*if(verifyCredentials(username, pHash)) {
            Intent intent = new Intent(this, MainActivity.class);
            Bundle b = new Bundle();
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
        }*/
    }

    private boolean verifyCredentials(String user, String pHash) {
        return true;
    }

}
