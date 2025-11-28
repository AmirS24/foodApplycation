package com.vacral.foodapplycation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vacral.foodapplycation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        this.enableEdgeToEdge()
        setContentView(binding!!.getRoot())
        binding!!.btnLogIn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                checlCredentials()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })
    }

    private fun checlCredentials() {
        val login = binding!!.textLogIn.getText().toString()
        val password = binding!!.textPassword.getText().toString()
        if (login == "admin" && password == "admin") {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Неверный логин или пароль!", Toast.LENGTH_SHORT).show()
        }
    }
}