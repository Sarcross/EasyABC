package edu.cpp.awh.easyabc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

import edu.cpp.awh.easyabc.model.Student;

public class AddStudentDialogFragment extends DialogFragment{
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText teacherEditText;
    private EditText parentEditText;
    private EditText schoolEditText;
    private Spinner gradeSpinner;
    private DatePicker dateOfBirthDatePicker;

    private Button addButton;
    public AddStudentDialogFragment() {

    }

    public static AddStudentDialogFragment newInstance(String title) {
        AddStudentDialogFragment frag = new AddStudentDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_student, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firstNameEditText = (EditText) view.findViewById(R.id.addStudentFragment_FirstName_EditText);
        lastNameEditText = (EditText) view.findViewById(R.id.addStudentFragment_LastName_EditText);
        teacherEditText = (EditText) view.findViewById(R.id.addStudentFragment_Teacher_EditText);
        parentEditText = (EditText) view.findViewById(R.id.addStudentFragment_Parent_EditText);
        schoolEditText = (EditText) view.findViewById(R.id.addStudentFragment_School_EditText);
        gradeSpinner = (Spinner) view.findViewById(R.id.addStudentFragment_grade_Spinner);
        dateOfBirthDatePicker = (DatePicker) view.findViewById(R.id.addStudentFragment_DOB_Spinner);


        addButton = (Button) view.findViewById(R.id.addStudentFragment_add_Button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("GradeLevel", gradeSpinner.getSelectedItem().toString());
                Student s = new Student().withFirstName(firstNameEditText.getText().toString())
                        .withLastName(lastNameEditText.getText().toString())
                        .withTeacher(teacherEditText.getText().toString())
                        .withParent(parentEditText.getText().toString())
                        .withSchool(schoolEditText.getText().toString())
                        .withDOB(new Date(dateOfBirthDatePicker.getYear(), dateOfBirthDatePicker.getMonth(), dateOfBirthDatePicker.getDayOfMonth()))
                        .withGradeLevel(Student.gradeLevelFromString(gradeSpinner.getSelectedItem().toString()));

                MainActivity.user.getStudentList().add(s);
                ((BaseAdapter) MainActivity.getStudentListView().getAdapter()).notifyDataSetChanged();
                AddStudentDialogFragment.this.dismiss();
            }
        });

        String title = getArguments().getString("title", "Add Student");
        getDialog().setTitle(title);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}
