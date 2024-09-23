package com.example.mydiary.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.mydiary.R;
import com.example.mydiary.core.Constant;

public class ProfileActivity extends Activity implements View.OnClickListener {
    private TextView fullName, userName, pass, email;
    private CardView btnUpdate;
    private ImageView btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        InitView();

        if (getSharedPreferences(Constant.MY_PREF_NAME, MODE_PRIVATE)
                .getString(Constant.FULL_NAME, null) != null) {
            fullName.setText(getSharedPreferences(Constant.MY_PREF_NAME, MODE_PRIVATE)
                    .getString(Constant.FULL_NAME, null));
            userName.setText(getSharedPreferences(Constant.MY_PREF_NAME, MODE_PRIVATE)
                    .getString(Constant.FULL_NAME, null));

        }
        if (getSharedPreferences(Constant.MY_PREF_NAME, MODE_PRIVATE)
                .getString(Constant.PASSWORD, null) != null) {
            pass.setText(getSharedPreferences(Constant.MY_PREF_NAME, MODE_PRIVATE)
                    .getString(Constant.PASSWORD, null));

        }

        btnUpdate.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    private void InitView() {
        fullName = findViewById(R.id.tv_fullName);
        userName = findViewById(R.id.tv_userName);
        pass = findViewById(R.id.tv_pass);
        btnBack = findViewById(R.id.iv_back);
                btnUpdate = findViewById(R.id.btn_update);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                break;
            case R.id.iv_back:
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));        }
    }
}
