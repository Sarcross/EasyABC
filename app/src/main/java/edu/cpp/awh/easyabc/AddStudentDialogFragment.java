package edu.cpp.awh.easyabc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by antzy_000 on 4/26/2017.
 */

public class AddStudentDialogFragment extends DialogFragment{
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText teacherEditText;
    private EditText parentEditText;
    private EditText schoolEditText;

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

        addButton = (Button) view.findViewById(R.id.addStudentFragment_add_Button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddStudentDialogFragment.this.dismiss();
            }
        });

        String title = getArguments().getString("title", "Login");
        getDialog().setTitle(title);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}
