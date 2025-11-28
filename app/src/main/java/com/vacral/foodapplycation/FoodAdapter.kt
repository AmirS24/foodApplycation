package com.vacral.foodapplycation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vacral.foodapplycation.databinding.ItemFoodBinding

// ИЗМЕНЕНИЕ №1: Убраны '?' - теперь список и ViewHolder не могут быть null.
class FoodAdapter(private val foodList: MutableList<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var selectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(
            LayoutInflater.from(parent.context), // Используем context из parent
            parent,
            false
        )
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        // ИЗМЕНЕНИЕ №2: Убран небезопасный '!!' и используется синтаксис [position]
        holder.bind(foodList[position])

        if (selectedPosition == position) {
            holder.itemView.isSelected = true
            holder.itemView.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start()
        } else {
            holder.itemView.isSelected = false
            holder.itemView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start()
        }
    }

    override fun getItemCount(): Int = foodList.size // Используем expression body для краткости

    // 'inner' здесь правильно, так как ViewHolder'у нужен доступ к полям и методам Adapter'а
    inner class FoodViewHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            // ИЗМЕНЕНИЕ №3: Упрощен синтаксис OnClickListener
            itemView.setOnClickListener {
                // ИЗМЕНЕНИЕ №4: Используем свойство 'bindingAdapterPosition' вместо устаревшего метода
                val clickedPosition = bindingAdapterPosition
                if (clickedPosition == RecyclerView.NO_POSITION || clickedPosition == selectedPosition) {
                    return@setOnClickListener
                }

                val clickedFood = foodList[clickedPosition]
                foodList.removeAt(clickedPosition)
                foodList.add(0, clickedFood)

                selectedPosition = 0

                notifyDataSetChanged()
            }
        }

        fun bind(food: Food) {
            // ИЗМЕНЕНИЕ №5: Используем синтаксис свойств Kotlin
            binding.tvFoodName.text = food.title
            binding.foodPrice.text = food.price
            binding.RatingBar.rating = food.rating

            Glide.with(itemView.context)
                .load(food.pic)
                .into(binding.tvFood)
        }
    }
}
