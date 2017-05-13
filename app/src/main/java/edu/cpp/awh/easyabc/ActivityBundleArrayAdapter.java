package edu.cpp.awh.easyabc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import edu.cpp.awh.easyabc.model.ActivityBundle;

public class ActivityBundleArrayAdapter extends ArrayAdapter<ActivityBundle> {
    private Context context;
    private int layoutResource;
    private List<ActivityBundle> activityBundleList;

    public ActivityBundleArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ActivityBundle> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResource = resource;
        this.activityBundleList = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layoutResource, parent, false);

        TextView topicTextView = (TextView) view.findViewById(R.id.activityBundleListView_topic_TextView);
        topicTextView.setText(activityBundleList.get(position).getTopic().toString());

        TextView antecedentTextView = (TextView) view.findViewById(R.id.activityBundleListView_antecedent_TextView);
        antecedentTextView.setText(activityBundleList.get(position).getActivity().toString());

        TextView behaviorTextView = (TextView) view.findViewById(R.id.activityBundleListView_behavior_TextView);
        behaviorTextView.setText(activityBundleList.get(position).getBehavior().toString());

        TextView consequenceTextView = (TextView) view.findViewById(R.id.activityBundleListView_consequence_TextView);
        consequenceTextView.setText(activityBundleList.get(position).getConsequence().toString());

        return view;
    }
}
