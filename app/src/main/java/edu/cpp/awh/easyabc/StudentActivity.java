package edu.cpp.awh.easyabc;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.cpp.awh.easyabc.data.FileManager;
import edu.cpp.awh.easyabc.model.Observation;
import edu.cpp.awh.easyabc.model.Student;

public class StudentActivity extends AppCompatActivity implements UI {
    private int position;
    protected List<Observation> observationList;
    protected static Student student;
    private ObservationArrayAdapter observationArrayAdapter;
    private static ListView observationListView;
    private FloatingActionButton addObservationFAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
            position = bundle.getInt("position");
        fillObservationList();
        setUpUI();
    }

    @Override
    protected void onStop() {
        super.onStop();
        FileManager.saveData(MainActivity.user, this);
    }


    @Override
    public void setUpUI() {
        this.setTitle(student.getFirstName() + " " + student.getLastName());
        observationListView = (ListView) findViewById(R.id.studentActivity_observation_ListView);

        addObservationFAB = (FloatingActionButton) findViewById(R.id.studentActivity_add_observation_FAB);
        addObservationFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, ObservationActivity.class);
                startActivity(intent);
            }
        });

        observationArrayAdapter = new ObservationArrayAdapter(this, R.layout.listview_observation_item, observationList);
        observationListView.setAdapter(observationArrayAdapter);
        observationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bun = new Bundle();
                bun.putInt("position", position);
                System.out.println(bun);
                System.out.println(bun.getInt("position"));

                Intent intent = new Intent(StudentActivity.this, ObservationActivity.class);
                intent.putExtras(bun);
                startActivity(intent, bun);

            }
        });

        observationListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO: Refine confirmation dialog
                observationList.remove(position);
                ((BaseAdapter) observationListView.getAdapter()).notifyDataSetChanged();
                Toast t = Toast.makeText(StudentActivity.this.getApplicationContext(), "Deleted", Toast.LENGTH_LONG);
                t.show();
                return true;
            }
        });


    }

    public void fillObservationList() {
        student = MainActivity.user.getStudentList().get(position);
        observationList = student.getObservationList();
    }

    public static ListView getObservationListView() {
        return observationListView;
    }

}
