package edu.cpp.awh.easyabc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import edu.cpp.awh.easyabc.data.FileManager;
import edu.cpp.awh.easyabc.model.ActivityBundle;
import edu.cpp.awh.easyabc.model.Observation;
import edu.cpp.awh.easyabc.model.Student;

public class ObservationActivity extends AppCompatActivity implements UI {
    protected static Observation observation;
    private int position;
    private Button startObservationButton;
    private Button endObservationButton;
    private static ListView activityBundleListView;
    private FloatingActionButton addActivityBundleFAB;

    private ActivityBundleArrayAdapter activityBundleArrayAdapter;
    private ArrayList<ActivityBundle> activityBundleList;
    private boolean observationStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation);
        System.out.println(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            position = bundle.getInt("position");
            observation = StudentActivity.student.getObservationList().get(position);
            activityBundleList = observation.getActivityBundleList();
            this.setTitle(observation.getObservationStart().toString());
        }
        else {
            observation = new Observation();
            this.setTitle("New Observation");
        }

        activityBundleList = observation.getActivityBundleList();
        observationStarted = false;

        setUpUI();
    }

    @Override
    protected void onStop() {
        super.onStop();
        FileManager.saveData(MainActivity.user, this);
    }

    @Override
    public void setUpUI() {
        startObservationButton = (Button) findViewById(R.id.observationActivity_start_observation_button);
        endObservationButton = (Button) findViewById(R.id.observationActivity_end_observation_button);
        activityBundleListView = (ListView) findViewById(R.id.observationActivity_activityBundle_ListView);
        addActivityBundleFAB = (FloatingActionButton) findViewById(R.id.observationActivity_addActivityBundle_FAB);

        startObservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ObservationActivity.this.observationStarted) {
                    updateObservationStart();
                }
            }
        });

        endObservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ObservationActivity.this.observationStarted) {
                    ObservationActivity.this.observationStarted = false;
                    observation.setObservationEnd(new Date());
                    StudentActivity.student.getObservationList().add(observation);
                    ((BaseAdapter) StudentActivity.getObservationListView().getAdapter()).notifyDataSetChanged();

                    //TODO: Add dialog for location and other notes
                    //observation.setLocation();
                    //observation.setNotes();
                    ObservationActivity.this.finish();
                }
            }
        });

        activityBundleArrayAdapter = new ActivityBundleArrayAdapter(this, R.layout.listview_activitybundle_item, activityBundleList);
        activityBundleListView.setAdapter(activityBundleArrayAdapter);

        activityBundleListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO: Refine confirmation dialog
                activityBundleList.remove(position);
                ((BaseAdapter) activityBundleListView.getAdapter()).notifyDataSetChanged();

                Toast t = Toast.makeText(ObservationActivity.this.getApplicationContext(), "Deleted", Toast.LENGTH_LONG);
                t.show();
                return true;
            }
        });

        addActivityBundleFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ObservationActivity.this.observationStarted) {
                    updateObservationStart();
                }
                FragmentManager fm = getSupportFragmentManager();
                AddActivityBundleDialogFragment addActivityBundleDialogFragment = AddActivityBundleDialogFragment.newInstance("Add Behavior");
                addActivityBundleDialogFragment.show(fm, "fragment_add_activity_bundle");
            }
        });
    }

    private void updateObservationStart() {
        ObservationActivity.this.observationStarted = true;
        observation.setObservationStart(new Date());
        ObservationActivity.this.setTitle(observation.getObservationStart().toString());
    }


    public static ListView getActivityBundleListView() {
        return activityBundleListView;
    }
}
