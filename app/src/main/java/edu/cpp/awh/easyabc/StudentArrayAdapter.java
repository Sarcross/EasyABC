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

import edu.cpp.awh.easyabc.model.Student;

public class StudentArrayAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int layoutResource;
    private List<Student> studentList;

    public StudentArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResource = resource;
        this.studentList = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layoutResource, parent, false);

        TextView nameTextView = (TextView) view.findViewById(R.id.studentListView_name_TextView);
        nameTextView.setText(studentList.get(position).getFirstName() + " " + studentList.get(position).getLastName());

        TextView gradeTextView = (TextView) view.findViewById(R.id.studentListView_grade_TextView);
        gradeTextView.setText("Grade: " + studentList.get(position).getGradeLevelString());

        TextView schoolTextView = (TextView) view.findViewById(R.id.studentListView_school_TextView);
        schoolTextView.setText(studentList.get(position).getSchool());

        return view;
    }
}
