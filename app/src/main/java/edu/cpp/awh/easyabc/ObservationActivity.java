package edu.cpp.awh.easyabc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;

import edu.cpp.awh.easyabc.model.ActivityBundle;

public class ObservationActivity extends AppCompatActivity implements UI {
    private Button startObservationButton;
    private Button endObservationButton;

    private ArrayList<ActivityBundle> activityBundleList;
    private boolean observationStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation);

        activityBundleList = new ArrayList<>();
        observationStarted = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void setUpUI() {
        //TODO: Change to observation.date
        this.setTitle((new Date()).toString());
        startObservationButton = (Button) findViewById(R.id.observationActivity_start_observation_button);
        endObservationButton = (Button) findViewById(R.id.observationActivity_end_observation_button);

        startObservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ObservationActivity.this.observationStarted) {
                    ObservationActivity.this.observationStarted = true;
                    //Observation.setStart(now)
                }
            }
        });

        endObservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ObservationActivity.this.observationStarted) {
                    ObservationActivity.this.observationStarted = false;
                    //Observation.setEnd(now)
                }
            }
        });
    }
}
