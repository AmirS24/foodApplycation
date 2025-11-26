package com.vacral.foodapplycation;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.vacral.foodapplycation.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        binding.btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checlCredentials();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void checlCredentials(){
        String login = binding.textLogIn.getText().toString();
        String password = binding.textPassword.getText().toString();
        if (login.equals("admin")&& password.equals("admin")){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();}else {
        Toast.makeText(this, "Неверный логин или пароль!", Toast.LENGTH_SHORT).show();
        }
    }
}