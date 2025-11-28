package com.vacral.foodapplycation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        val splashScreenView = findViewById<View>(R.id.SplashScreen)

        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_shape_screen)

        // 5. Применяем и запускаем загруженную анимацию для нашего элемента.
        splashScreenView.startAnimation(animation)


        Handler().postDelayed(object : Runnable {
            override fun run() {
                // Создаем "намерение" (Intent) для перехода на MainActivity
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)


                finish()
            }
        }, 1200)
    }
}