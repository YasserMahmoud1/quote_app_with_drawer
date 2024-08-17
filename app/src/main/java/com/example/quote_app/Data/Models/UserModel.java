package com.example.quote_app.Data.Models;

public class UserModel {
    private final String name;
    private final String email;
    private final String password;
    private final String country;
    private final String phone;
    public UserModel(String name, String email, String password, String country, String phone){
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.phone = phone;
    }



    public boolean checkPassword(String newPassword) {
        return this.password.equals(newPassword);
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }
}
