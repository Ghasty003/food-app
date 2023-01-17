package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.google.android.material.button.MaterialButton;

public class ThirdIntroActivity extends AppCompatActivity {
    float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_intro);

        MaterialButton materialButton = findViewById(R.id.continueBtn);

        materialButton.setOnClickListener(view -> {
            startActivity(new Intent(this, SplashScreenActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();

                if (x1 < x2) {
                    startActivity(new Intent(ThirdIntroActivity.this, SecondIntroActivity.class));
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }

                break;
        }
        return super.onTouchEvent(event);
    }
}