package com.vacral.foodapplycation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.vacral.foodapplycation.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var binding: ActivityHomeBinding? = null
    private var categoryAdapter: CategoryAdapter? = null
    private var categories: MutableList<Category?>? = null
    private var foodList: MutableList<Food?>? = null
    private var foodAdapter: FoodAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(getLayoutInflater())
        this.enableEdgeToEdge()
        setContentView(binding!!.getRoot())
        setupRecyclerView()
        loadCategories()
        loadFood()
        setupFoodRecyclerView()


        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        binding!!.categoriesRecyclerView.setLayoutManager(layoutManager)
    }

    private fun loadCategories() {
        categories = ArrayList<Category?>()
        categories!!.add(Category("Burger", R.drawable.ic_burger))
        categories!!.add(Category("Pizza", R.drawable.pizza_2))
        categories!!.add(Category("Chicken", R.drawable.chicken_svgrepo_com))
        categories!!.add(Category("Sushi", R.drawable.sushi_svgrepo_com))

        categoryAdapter = CategoryAdapter(categories, this)
        binding!!.categoriesRecyclerView.setAdapter(categoryAdapter)
    }

    private fun setupFoodRecyclerView() {}
    private fun loadFood() {
        foodList = ArrayList<Food?>()
        foodList!!.add(Food("Salad Burger", 4.5f, R.drawable.salad_burger, "12$"))
        foodList!!.add(Food("Pizza London", 3.5f, R.drawable.pizza, "15$"))
        foodList!!.add(Food("Sushi California", 5.0f, R.drawable.sushi, "17$"))
        foodList!!.add(Food("KFC chiken", 5.0f, R.drawable.chiken, "9$"))

        foodAdapter = FoodAdapter(foodList)
        binding!!.foodRecyclereview.setAdapter(foodAdapter)
    }
}