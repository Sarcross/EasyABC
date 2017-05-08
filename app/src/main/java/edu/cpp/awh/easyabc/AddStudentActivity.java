package edu.cpp.awh.easyabc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.cpp.awh.easyabc.util.Logging;

public class AddStudentActivity extends AppCompatActivity implements UI{
    private Button addStudentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        Log.d(Logging.TAG_ADD_STUDENT_ACTIVITY, Logging.DEBUG_LAUNCH_ACTIVITY);

        setUpUI();
    }


    @Override
    public void setUpUI() {
        addStudentButton = (Button) findViewById(R.id.addStudentActivity_add_button);
        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddStudentActivity.this.finish();
            }
        });
    }
}
