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

import edu.cpp.awh.easyabc.model.Observation;

public class ObservationArrayAdapter extends ArrayAdapter<Observation>{
    private Context context;
    private int layoutResource;
    private List<Observation> observationList;



    public ObservationArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Observation> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResource = resource;
        this.observationList = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layoutResource, parent, false);

        TextView observationDateTextView = (TextView) view.findViewById(R.id.observationListView_observationDate_TextView);
        TextView observationLocationTextView = (TextView) view.findViewById(R.id.observationListView_observationLocation_TextView);

        observationDateTextView.setText(observationList.get(position).getObservationStart().toString());
        observationLocationTextView.setText("Location: " + observationList.get(position).getLocation());

        return view;
    }
}
