package com.example.quote_app.Data.Repos;


import androidx.annotation.Nullable;

import com.example.quote_app.Data.Models.UserModel;

import java.util.ArrayList;


public class UserRepo {
    static private final ArrayList<UserModel> users = new ArrayList<>();

    public static void addUser(UserModel user){
        users.add(user);
    }

    @Nullable
    public static UserModel getUserByEmail(String email){
        for (UserModel user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
