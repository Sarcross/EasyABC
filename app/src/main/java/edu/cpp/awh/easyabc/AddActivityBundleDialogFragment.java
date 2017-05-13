package edu.cpp.awh.easyabc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

import edu.cpp.awh.easyabc.model.ActivityBundle;

import static android.view.View.GONE;

public class AddActivityBundleDialogFragment extends DialogFragment {
    private EditText topicEditText;
    private EditText consequenceOtherEditText;
    private Spinner activitySpinner;
    private Spinner antecedentSpinner;
    private Spinner behaviorSpinner;
    private Spinner consequenceSpinner;
    private Button addButton;

    public AddActivityBundleDialogFragment() {

    }

    public static AddActivityBundleDialogFragment newInstance(String title) {
        AddActivityBundleDialogFragment frag = new AddActivityBundleDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_activity_bundle, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        topicEditText  = (EditText) getView().findViewById(R.id.addActivityBundleFragment_topic_EditText);
        consequenceOtherEditText = (EditText) getView().findViewById(R.id.addActivityBundleFragment_consequence_other_EditText);
        activitySpinner = (Spinner) getView().findViewById(R.id.addActivityBundleFragment_activity_Spinner);
        antecedentSpinner = (Spinner) getView().findViewById(R.id.addActivityBundleFragment_antecedent_Spinner);
        behaviorSpinner = (Spinner) getView().findViewById(R.id.addActivityBundleFragment_behavior_Spinner);
        consequenceSpinner = (Spinner) getView().findViewById(R.id.addActivityBundleFragment_consequence_Spinner);
        addButton = (Button) getView().findViewById(R.id.addActivityBundleFragment_add_Button);

        consequenceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(consequenceSpinner.getSelectedItemPosition() == getResources().getStringArray(R.array.consequence_arrays).length - 1) {
                    consequenceOtherEditText.setVisibility(View.VISIBLE);
                }
                else
                    consequenceOtherEditText.setVisibility(GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityBundle activityBundle = new ActivityBundle();
                if(topicEditText.getText().length() == 0)
                    activityBundle.setTopic("No Topic");
                else
                    activityBundle.setTopic(topicEditText.getText().toString());
                activityBundle.setTime(new Date());
                activityBundle.setActivity(ActivityBundle.activityFromString(activitySpinner.getSelectedItem().toString()));
                activityBundle.setAntecedent(ActivityBundle.antecedentFromString(antecedentSpinner.getSelectedItem().toString()));
                activityBundle.setBehavior(ActivityBundle.behaviorFromString(behaviorSpinner.getSelectedItem().toString()));
                activityBundle.setConsequence(ActivityBundle.consequenceFromString(consequenceSpinner.getSelectedItem().toString()));
                activityBundle.setConsequenceOption(consequenceOtherEditText.getText().toString());
                ObservationActivity.observation.getActivityBundleList().add(activityBundle);
                ((BaseAdapter) ObservationActivity.getActivityBundleListView().getAdapter()).notifyDataSetChanged();
                AddActivityBundleDialogFragment.this.dismiss();

            }
        });

        String title = getArguments().getString("title", "Behavior");
        getDialog().setTitle(title);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}