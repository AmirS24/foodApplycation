package com.vacral.foodapplycation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        View splashScreenView = findViewById(R.id.SplashScreen);

Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_shape_screen);

        // 5. Применяем и запускаем загруженную анимацию для нашего элемента.
        splashScreenView.startAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Создаем "намерение" (Intent) для перехода на MainActivity
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);


                finish();
            }
        }, 1200);
    }
}