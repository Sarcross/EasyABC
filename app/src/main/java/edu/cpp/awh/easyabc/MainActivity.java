package edu.cpp.awh.easyabc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.cpp.awh.easyabc.data.DatabaseHelper;
import edu.cpp.awh.easyabc.model.ActivityBundle;
import edu.cpp.awh.easyabc.model.Observation;
import edu.cpp.awh.easyabc.model.Student;
import edu.cpp.awh.easyabc.model.User;
import edu.cpp.awh.easyabc.util.Logging;

public class MainActivity extends AppCompatActivity implements UI{
    public User user;
    protected List<Student> studentList;
    private StudentArrayAdapter studentArrayAdapter;
    private ListView studentListView;
    private FloatingActionButton addStudentFAB;

    private DatabaseHelper databaseHelper = null;
    private Dao<Student, Integer> studentDao;
    private Dao<Observation, Integer> observationDao;
    private Dao<ActivityBundle, Integer> activityBundleDao;
    private Dao<User, Integer> userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Logging.TAG_MAIN_ACTIVITY, Logging.DEBUG_LAUNCH_ACTIVITY);

        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        try
        {
            userDao = databaseHelper.getUserDao();
            studentDao = databaseHelper.getStudentDao();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        populateStudentListView();
        setUpUI();

        if(user != null) {

            Log.d(Logging.TAG_MAIN_ACTIVITY, user.getName() + " logged in");
        }
        else {
            showLoginDialog();
            //user = new User("User", "password");
        }


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

    @Override
    protected void onStart() {
        super.onStart();

        populateStudentListView();

        //Log.e("Test", Crypto.encrypt("Hello", Crypto.getHash("Hi")));
        //Log.e("Test", Crypto.decrypt(Crypto.encrypt("Hello", "Hi"), Crypto.getHash("Hi")));
    }

    public void setUpUI() {
        studentListView = (ListView) findViewById(R.id.mainActivity_StudentListView);
        addStudentFAB = (FloatingActionButton) findViewById(R.id.mainActivity_add_student_FAB);
        addStudentFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show Dialog
                if(MainActivity.this.user == null) {
                    //showLoginDialog();
                    showAddStudentDialog();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                    startActivity(intent);
                }


            }
        });

        studentArrayAdapter = new StudentArrayAdapter(this, R.layout.listview_student_item, studentList);
        studentListView.setAdapter(studentArrayAdapter);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student s = (Student) studentListView.getItemAtPosition(position);
                Bundle bun = new Bundle();
                //bun.putInt("id", s.getId());
                bun.putString("firstName", s.getFirstName());
                bun.putString("lastName", s.getLastName());
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(intent, bun);

            }
        });
    }

    //TODO: Implement DB Access, update studentListView
    public void populateStudentListView() {

        /*
        Temporary
         */
        studentList = new ArrayList<>();
        studentList.add(new Student().withFirstName("Bob").withLastName("Kid").withSchool("Fremont Elementary School").withGradeLevel(Student.GradeLevel.G1));
        studentList.add(new Student().withFirstName("Sally").withLastName("Child").withSchool("Ballantyne Elementary School").withGradeLevel(Student.GradeLevel.G5));
        studentList.add(new Student().withFirstName("Timmy").withLastName("Student").withSchool("West Valley High School").withGradeLevel(Student.GradeLevel.G12));

        studentList.add(new Student().withFirstName("Bob").withLastName("Kid").withSchool("Fremont Elementary School").withGradeLevel(Student.GradeLevel.G1));
        studentList.add(new Student().withFirstName("Sally").withLastName("Child").withSchool("Ballantyne Elementary School").withGradeLevel(Student.GradeLevel.G5));
        studentList.add(new Student().withFirstName("Timmy").withLastName("Student").withSchool("West Valley High School").withGradeLevel(Student.GradeLevel.G12));
        studentList.add(new Student().withFirstName("Bob").withLastName("Kid").withSchool("Fremont Elementary School").withGradeLevel(Student.GradeLevel.G1));
        studentList.add(new Student().withFirstName("Sally").withLastName("Child").withSchool("Ballantyne Elementary School").withGradeLevel(Student.GradeLevel.G5));
        studentList.add(new Student().withFirstName("Timmy").withLastName("Student").withSchool("West Valley High School").withGradeLevel(Student.GradeLevel.G12));
        studentList.add(new Student().withFirstName("Bob").withLastName("Kid").withSchool("Fremont Elementary School").withGradeLevel(Student.GradeLevel.G1));
        studentList.add(new Student().withFirstName("Sally").withLastName("Child").withSchool("Ballantyne Elementary School").withGradeLevel(Student.GradeLevel.G5));
        studentList.add(new Student().withFirstName("Timmy").withLastName("Student").withSchool("West Valley High School").withGradeLevel(Student.GradeLevel.G12));
        studentList.add(new Student().withFirstName("Bob").withLastName("Kid").withSchool("Fremont Elementary School").withGradeLevel(Student.GradeLevel.G1));
        studentList.add(new Student().withFirstName("Sally").withLastName("Child").withSchool("Ballantyne Elementary School").withGradeLevel(Student.GradeLevel.G5));
        studentList.add(new Student().withFirstName("Timmy").withLastName("Student").withSchool("West Valley High School").withGradeLevel(Student.GradeLevel.G12));
        studentList.add(new Student().withFirstName("Bob").withLastName("Kid").withSchool("Fremont Elementary School").withGradeLevel(Student.GradeLevel.G1));
        studentList.add(new Student().withFirstName("Sally").withLastName("Child").withSchool("Ballantyne Elementary School").withGradeLevel(Student.GradeLevel.G5));
        studentList.add(new Student().withFirstName("Timmy").withLastName("Student").withSchool("West Valley High School").withGradeLevel(Student.GradeLevel.G12));
        studentList.add(new Student().withFirstName("Bob").withLastName("Kid").withSchool("Fremont Elementary School").withGradeLevel(Student.GradeLevel.G1));
        studentList.add(new Student().withFirstName("Sally").withLastName("Child").withSchool("Ballantyne Elementary School").withGradeLevel(Student.GradeLevel.G5));
        studentList.add(new Student().withFirstName("Timmy").withLastName("Student").withSchool("West Valley High School").withGradeLevel(Student.GradeLevel.G12));
        studentList.add(new Student().withFirstName("Bob").withLastName("Kid").withSchool("Fremont Elementary School").withGradeLevel(Student.GradeLevel.G1));
        studentList.add(new Student().withFirstName("Sally").withLastName("Child").withSchool("Ballantyne Elementary School").withGradeLevel(Student.GradeLevel.G5));
        studentList.add(new Student().withFirstName("Timmy").withLastName("Student").withSchool("West Valley High School").withGradeLevel(Student.GradeLevel.G12));
    }

}
