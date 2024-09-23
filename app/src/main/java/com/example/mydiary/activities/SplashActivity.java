package com.example.mydiary.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mydiary.R;
import com.example.mydiary.core.Constant;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo, name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.iv_logo);
        name = findViewById(R.id.iv_name);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (
                        getSharedPreferences(Constant.MY_PREF_NAME, MODE_PRIVATE)
                                .getString(Constant.PREF_TOKEN, null) != null
                )
                {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));


                } else {
/*
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
*/
                   Intent intent = new Intent(SplashActivity.this , LoginActivity.class);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this,
                            Pair.create(logo , "logo"),
                            Pair.create(name , "logo_text"));

                    startActivity(intent , options.toBundle());
                }

                finish();
            }
        }, 3000);
    }
}

 /*Intent intent = new Intent(SplashActivity.this , LoginActivity.class);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this,
                            Pair.create(logo , "logo"),
                            Pair.create(name , "logo_text"));

                    startActivity(intent , options.toBundle());*/
