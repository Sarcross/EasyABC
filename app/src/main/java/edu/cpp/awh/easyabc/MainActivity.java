package edu.cpp.awh.easyabc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edu.cpp.awh.easyabc.data.FileManager;
import edu.cpp.awh.easyabc.model.Student;
import edu.cpp.awh.easyabc.model.User;
import edu.cpp.awh.easyabc.util.Logging;

public class MainActivity extends AppCompatActivity implements UI{
    protected static User user;
    protected List<Student> studentList;
    private StudentArrayAdapter studentArrayAdapter;
    private static ListView studentListView;
    private FloatingActionButton addStudentFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Logging.TAG_MAIN_ACTIVITY, Logging.DEBUG_LAUNCH_ACTIVITY);

        setContentView(R.layout.activity_main);
        setUpData();
        setUpUI();
    }

    private void setUpData() {
        user = FileManager.loadData(user, this);
        if(user == null)
            user = new User();
        studentList = user.getStudentList();
    }

    @Override
    protected void onStop() {
        super.onStop();
        FileManager.saveData(user, this);
    }

    private void showLoginDialog() {
        FragmentManager fm = getSupportFragmentManager();
        LoginDialogFragment loginDialogFragment = LoginDialogFragment.newInstance("Login", this);
        loginDialogFragment.setCancelable(false);
        loginDialogFragment.show(fm, "fragment_login");


    }

    private void showAddStudentDialog() {
        FragmentManager fm = getSupportFragmentManager();
        AddStudentDialogFragment addStudentDialogFragment = AddStudentDialogFragment.newInstance("Add Student");
        addStudentDialogFragment.show(fm, "fragment_add_student");
    }

    public void setUpUI() {
        //setTitle(R.string.app_name. + " - Student List");
        studentListView = (ListView) findViewById(R.id.mainActivity_StudentListView);
        addStudentFAB = (FloatingActionButton) findViewById(R.id.mainActivity_add_student_FAB);
        addStudentFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddStudentDialog();
            }
        });

        studentArrayAdapter = new StudentArrayAdapter(this, R.layout.listview_student_item, studentList);
        studentListView.setAdapter(studentArrayAdapter);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student s = (Student) studentListView.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                Bundle bun = new Bundle();
                bun.putInt("position", position);
                startActivity(intent, bun);

            }
        });
        studentListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO: Refine confirmation dialog
                studentList.remove(position);
                ((BaseAdapter) studentListView.getAdapter()).notifyDataSetChanged();
                Toast t = Toast.makeText(MainActivity.this.getApplicationContext(), "Deleted", Toast.LENGTH_LONG);
                t.show();
                return true;
            }
        });
    }

    public static ListView getStudentListView() {
        return studentListView;
    }
}
