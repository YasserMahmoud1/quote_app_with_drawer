package com.example.quote_app.UI.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quote_app.Data.Repos.UserRepo;
import com.example.quote_app.Data.Models.UserModel;
import com.example.quote_app.R;


public class RegisterationFragment extends Fragment {

    Spinner spinner;
    Button button;
    EditText name;
    EditText email;
    EditText password;
    EditText phone;
    TextView errorText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registeration, container, false);
        spinner =  view.findViewById(R.id.registerSpinner);
        button = view.findViewById(R.id.registerBtn);
        name = view.findViewById(R.id.registerEditName);
        email = view.findViewById(R.id.registerEditEmail);
        password = view.findViewById(R.id.registerEditPassword);
        phone = view.findViewById(R.id.registerEditPhone);
        errorText = view.findViewById(R.id.spinnerErrorText);

        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getContext(),R.array.spinner_items, android.R.layout.simple_spinner_item);
        aa.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinner.setSelection(0,false);
        spinner.setAdapter(aa);

        button.setOnClickListener(this::register);

        return view;
    }

    public void register(View view){
        boolean valid = false;
        if(name.getText().toString().isEmpty()){
            name.setError("Name Cannot be Empty");
        }if(email.getText().toString().isEmpty()){
            email.setError("Name Cannot be Empty");
        }if(password.getText().toString().isEmpty()){
            password.setError("Name Cannot be Empty");
        }if(phone.getText().toString().isEmpty()){
            phone.setError("Name Cannot be Empty");
        }
        if(spinner.getSelectedItem().toString().equals("Choose a country")) {
            errorText.setVisibility(View.VISIBLE);
        }else{
            errorText.setVisibility(View.INVISIBLE);
            valid = true;
        }


        if (valid){
            UserModel user = new UserModel(name.getText().toString(),email.getText().toString(),password.getText().toString(),spinner.getSelectedItem().toString(),phone.getText().toString());
            if(UserRepo.getUserByEmail(user.getEmail()) != null){
                Toast.makeText(getContext(), "ERROR: User with same email is already exists",Toast.LENGTH_SHORT).show();
            }else{
                UserRepo.addUser(user);
                phone.setText("");
                name.setText("");
                email.setText("");
                password.setText("");
                spinner.setSelection(0);

                Toast.makeText(getContext(), "User Added",Toast.LENGTH_SHORT).show();

                ViewPager2 viewPager = getActivity().findViewById(R.id.viewPager);
                viewPager.setCurrentItem(0);
            }

        }


    }
}