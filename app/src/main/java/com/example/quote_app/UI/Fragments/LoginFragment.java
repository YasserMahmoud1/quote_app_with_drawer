package com.example.quote_app.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quote_app.Data.Repos.UserRepo;
import com.example.quote_app.Data.Models.UserModel;
import com.example.quote_app.R;
import com.example.quote_app.UI.Activities.HomeActivity;

public class LoginFragment extends Fragment {
    EditText email;
    EditText password;
    Button loginBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        // Inflate the layout for this fragment
        email = view.findViewById(R.id.loginEditEmail);
        password = view.findViewById(R.id.loginEditPassword);
        loginBtn = view.findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(view1 -> login());

        return view;
    }

    public void login(){
        boolean valid = true;
        if(email.getText().toString().isEmpty()){
            email.setError("Email cannot be empty");
            valid = false;
        }
        if(password.getText().toString().isEmpty()){
            password.setError("Password cannot be empty");
            valid= false;
        }
        if(valid){
            UserModel user = UserRepo.getUserByEmail(email.getText().toString());
            if(user != null ) {
                if(!user.checkPassword(password.getText().toString())){
                    Toast.makeText(getContext(), "ERROR: Password is incorrect",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Signed In",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("UserName",user.getName());
                    startActivity(intent);
                }
            }else {
                Toast.makeText(getContext(), "ERROR: User Not Added",Toast.LENGTH_SHORT).show();
            }

        }
    }
}