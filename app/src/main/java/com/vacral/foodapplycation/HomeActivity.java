package com.vacral.foodapplycation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.vacral.foodapplycation.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private CategoryAdapter categoryAdapter;
    private List<Category> categories;
 private List<Food> foodList;
 private  FoodAdapter foodAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        setupRecyclerView();
       loadCategories();
       loadFood();
       setupFoodRecyclerView();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


        binding.categoriesRecyclerView.setLayoutManager(layoutManager);
    }

    private void loadCategories() {
        categories = new ArrayList<>();
        categories.add(new Category("Burger", R.drawable.ic_burger));
        categories.add(new Category("Pizza", R.drawable.pizza_2));
        categories.add(new Category("Chicken", R.drawable.chicken_svgrepo_com));
        categories.add(new Category("Sushi", R.drawable.sushi_svgrepo_com));

        categoryAdapter = new  CategoryAdapter(categories, this);
        binding.categoriesRecyclerView.setAdapter(categoryAdapter);


    }
    private void setupFoodRecyclerView(){}
    private void loadFood() {
foodList = new ArrayList<>();
foodList.add(new Food("Salad Burger",4.5f,R.drawable.salad_burger, "12$"));
foodList.add(new Food("Pizza London",3.5f,R.drawable.pizza, "15$"));
foodList.add(new Food("Sushi California",5.0f,R.drawable.sushi, "17$"));
foodList.add(new Food("KFC chiken",5.0f,R.drawable.chiken, "9$"));

foodAdapter = new FoodAdapter(foodList);
binding.foodRecyclereview.setAdapter(foodAdapter);

    }

}