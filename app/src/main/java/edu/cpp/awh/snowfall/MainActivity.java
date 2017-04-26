package edu.cpp.awh.snowfall;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import edu.cpp.awh.snowfall.cryptography.Crypto;
import edu.cpp.awh.snowfall.model.User;
import edu.cpp.awh.snowfall.util.Logging;

public class MainActivity extends AppCompatActivity implements UI{
    protected User user;
    private ListView studentListView;
    private FloatingActionButton addStudentFAB;
    //private Button addStudentButton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Logging.TAG_MAIN_ACTIVITY, Logging.DEBUG_LAUNCH_ACTIVITY);

        setContentView(R.layout.activity_main);


        setUpUI();

        if(user != null) {
            user = new User().withUsername(savedInstanceState.getString("username")).withPassword(savedInstanceState.getString("password"));
            Log.d(Logging.TAG_MAIN_ACTIVITY, user.getName() + " logged in");
        }
        else {
            user = new User("User", "password");
        }

        populateStudentListView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        verifyLoginStatus();
        populateStudentListView();

        //Log.e("Test", Crypto.encrypt("Hello", Crypto.getHash("Hi")));
        //Log.e("Test", Crypto.decrypt(Crypto.encrypt("Hello", "Hi"), Crypto.getHash("Hi")));
    }

    //TODO: Implement DB Access, try login action
    private void verifyLoginStatus() {
        if(user == null) {
            Log.w(Logging.TAG_MAIN_ACTIVITY, Logging.WARN_NULL_VALUE + User.class);
            launchLoginActivity();
        }
    }

    private void launchLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void setUpUI() {
        studentListView = (ListView) findViewById(R.id.mainActivity_StudentListView);
        addStudentFAB = (FloatingActionButton) findViewById(R.id.mainActivity_add_student_FAB);
        addStudentFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Alert Dialog");
                alertDialog.setMessage("Dialog Content");
                alertDialog.show();*/
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);

            }
        });
        //https://guides.codepath.com/android/floating-action-buttons
    }

    //TODO: Implement DB Access, update studentListView
    public void populateStudentListView() {

    }

}
