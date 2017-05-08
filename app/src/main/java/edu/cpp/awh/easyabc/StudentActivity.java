package edu.cpp.awh.easyabc;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.cpp.awh.easyabc.model.Observation;
import edu.cpp.awh.easyabc.model.Student;

public class StudentActivity extends AppCompatActivity implements UI {
    protected List<Observation> observationList;
    protected Student student;
    private ObservationArrayAdapter observationArrayAdapter;
    private ListView observationListView;
    private FloatingActionButton addObservationFAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        //Temporary
        fillObservationList();
        setUpUI();
    }


    @Override
    public void setUpUI() {
        observationListView = (ListView) findViewById(R.id.studentActivity_observation_ListView);

        addObservationFAB = (FloatingActionButton) findViewById(R.id.studentActivity_add_observation_FAB);
        addObservationFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, Observation.class);
                startActivity(intent);
            }
        });

        observationArrayAdapter = new ObservationArrayAdapter(this, R.layout.listview_observation_item, observationList);
        observationListView.setAdapter(observationArrayAdapter);
        observationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Observation o = (Observation) observationListView.getItemAtPosition(position);
                Bundle bun = new Bundle();

                Intent intent = new Intent(StudentActivity.this, ObservationActivity.class);
                startActivity(intent, bun);

            }
        });


    }

    public void fillObservationList() {
        student = new Student();
        observationList = new ArrayList<>();
        observationList.add(new Observation().withLocation("House").withObservationStart(new Date()));
        observationList.add(new Observation().withLocation("Home").withObservationStart(new Date()));
        observationList.add(new Observation().withLocation("Here").withObservationStart(new Date()));
        observationList.add(new Observation().withLocation("There").withObservationStart(new Date()));
        observationList.add(new Observation().withLocation("Everywhere").withObservationStart(new Date()));
    }
}
