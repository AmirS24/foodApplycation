package com.vacral.foodapplycation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.vacral.foodapplycation.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    // Используем `lateinit`, чтобы не использовать nullable типы '?' и небезопасный оператор '!!'.
    // Это говорит компилятору: "Я обещаю инициализировать это позже, до первого использования".
    private lateinit var binding: ActivityHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categories: MutableList<Category>
    private lateinit var foodList: MutableList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCategoryRecyclerView()
        loadCategories()

        setupFoodRecyclerView()
        loadFood()

        // Более "котлиновский" способ установки слушателя
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupCategoryRecyclerView() {
        // Используем синтаксис свойств Kotlin для установки LayoutManager
        binding.categoriesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun loadCategories() {
        // Создаем изменяемый список с помощью `mutableListOf()`
        categories = mutableListOf(
            Category("Burger", R.drawable.ic_burger),
            Category("Pizza", R.drawable.pizza_2),
            Category("Chicken", R.drawable.chicken_svgrepo_com),
            Category("Sushi", R.drawable.sushi_svgrepo_com)
        )

        categoryAdapter = CategoryAdapter(categories)
        // Используем синтаксис свойств Kotlin для установки адаптера
        binding.categoriesRecyclerView.adapter = categoryAdapter
    }

    private fun setupFoodRecyclerView() {
        binding.foodRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun loadFood() {
        foodList = mutableListOf(
            Food("Salad Burger", 4.5f, R.drawable.salad_burger, "12$"),
            Food("Pizza London", 3.5f, R.drawable.pizza, "15$"),
            Food("Sushi California", 5.0f, R.drawable.sushi, "17$"),
            Food("KFC chiken", 5.0f, R.drawable.chiken, "9$")
        )

        foodAdapter = FoodAdapter(foodList)

        binding.foodRecyclerView.adapter = foodAdapter
    }
}
