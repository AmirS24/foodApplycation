package com.vacral.foodapplycation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vacral.foodapplycation.databinding.ItemCategoryFoodBinding

// ИЗМЕНЕНИЕ: Убран Context из конструктора и убраны все '?'
class CategoryAdapter(private val categories: MutableList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var selectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryFoodBinding.inflate(
            LayoutInflater.from(parent.context), // Используем context от родителя
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
        holder.itemView.isSelected = (selectedPosition == position)
    }

    override fun getItemCount(): Int = categories.size

    inner class CategoryViewHolder(private val binding: ItemCategoryFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val clickedPosition = bindingAdapterPosition
                if (clickedPosition == RecyclerView.NO_POSITION || clickedPosition == selectedPosition) {
                    return@setOnClickListener
                }

                notifyItemChanged(selectedPosition)
                selectedPosition = clickedPosition
                notifyItemChanged(selectedPosition)

                // Логика перемещения элемента на первую позицию
                val clickedCategory = categories[selectedPosition]
                categories.removeAt(selectedPosition)
                categories.add(0, clickedCategory)

                notifyItemMoved(selectedPosition, 0)
                selectedPosition = 0
            }
        }

        fun bind(category: Category) {
            binding.categoryName.text = category.categoryFood
            binding.categoryIcon.setImageResource(category.icon)
        }
    }
}
