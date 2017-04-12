package edu.cpp.awh.snowfall;

import edu.cpp.awh.snowfall.Model.User;
import edu.cpp.awh.snowfall.Util.Logging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements UI{
    protected User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Logging.TAG_MAIN_ACTIVITY, Logging.DEBUG_LAUNCH_ACTIVITY + this.getClass().getSimpleName());

        setContentView(R.layout.activity_main);

        setUpUI();
    }

    @Override
    protected void onStart() {
        super.onStart();

        verifyLoginStatus();
        populateStudentList();
    }

    private void verifyLoginStatus() {
        if(user == null) {
            Log.w(Logging.TAG_MAIN_ACTIVITY, Logging.WARN_NULL_VALUE + User.class);
            launchLoginActivity();
        }
    }

    private void launchLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        Bundle b = new Bundle();
        startActivity(intent);
    }

    private void populateStudentList() {

    }

    public void setUpUI() {
        TextView txtView = (TextView) findViewById(R.id.mainActivity_helloWorldText);
        txtView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Clicked The Text", Toast.LENGTH_LONG).show();
            }
        });
    }
}
