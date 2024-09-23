package com.example.mydiary.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.mydiary.R;
import com.example.mydiary.core.Constant;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static TextInputEditText userName;
    private static TextInputEditText Password;
    private String token;
    public static String username;
    public static String pass;
    static SharedPreferences shPref;
    String regex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        shPref = getSharedPreferences(Constant.MY_PREF_NAME, Context.MODE_PRIVATE);

    }
    public static boolean isValidUsername(String name)
    {
        // Regex to check valid username.
        String regex = "^[A-Za-z0-9_]{6,15}$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        // If the username is empty
        // return false
        if (name == null) {
            return false;
        }
        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher(name);
        // Return if the username
        // matched the ReGex
        return m.matches();
    }
    public static boolean isValidPassword(String pass)
    {
        // Regex to check valid username.
        String regex = "^[A-Za-z0-9.]{6,15}$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        // If the username is empty
        // return false
        if (pass == null) {
            return false;
        }
        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher(pass);
        // Return if the username
        // matched the ReGex
        return m.matches();
    }

    private void initViews() {
        CardView btnLogin = findViewById(R.id.btn_login);
        userName = findViewById(R.id.et_user_nam);
        Password = findViewById(R.id.et_password);

        btnLogin.setOnClickListener(this);
    }

    private String login(String userName, String password) {
        return "dgdjkl";

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if(isValidUsername(userName.getText().toString())
                        &&  isValidPassword(Password.getText().toString())) {
                token = login(userName.getText().toString(), Password.getText().toString());
              getSharedPreferences(Constant.MY_PREF_NAME, MODE_PRIVATE)
                        .edit()
                        .putString(Constant.PREF_TOKEN, token)
                        .apply();

                  username = userName.getText().toString();
                    pass = Password.getText().toString();

                    SharedPreferences.Editor sEdit = shPref.edit();
                    sEdit.putString(Constant.FULL_NAME, username);
                    sEdit.putString(Constant.PASSWORD, pass);
                    sEdit.apply();

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
              }else{
                  Toast.makeText(this,"Uppercase,lowerCase,number,_ OR pass",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, LoginActivity.class));
              }



/*
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_LONG).show();
*/


                finish();
                break;
        }
    }
}


