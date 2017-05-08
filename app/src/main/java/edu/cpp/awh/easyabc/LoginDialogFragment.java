package edu.cpp.awh.easyabc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import edu.cpp.awh.easyabc.data.DatabaseHelper;
import edu.cpp.awh.easyabc.model.User;

public class LoginDialogFragment extends DialogFragment {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private Button loginButton;
    private DatabaseHelper databaseHelper;
    private Dao<User, Integer> userDao;

    public LoginDialogFragment() {

    }

    public static LoginDialogFragment newInstance(String title, Context context) {
        LoginDialogFragment frag = new LoginDialogFragment();
        frag.databaseHelper = new DatabaseHelper(context);


        try
        {
            frag.userDao = frag.databaseHelper.getUserDao();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usernameEditText = (EditText) view.findViewById(R.id.loginFragment_username_EditText);
        passwordEditText = (EditText) view.findViewById(R.id.loginFragment_password_EditText);
        registerButton = (Button) view.findViewById(R.id.loginFragment_register_Button);
        loginButton = (Button) view.findViewById(R.id.loginFragment_login_Button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDialogFragment.this.dismiss();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDialogFragment.this.dismiss();
            }
        });

        String title = getArguments().getString("title", "Login");
        getDialog().setTitle(title);
        usernameEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}
