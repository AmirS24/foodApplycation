package com.vacral.foodapplycation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vacral.foodapplycation.CategoryAdapter.ItemCategoryViewHolder
import com.vacral.foodapplycation.databinding.ItemCategoryFoodBinding

class CategoryAdapter(
    private val categories: MutableList<Category>,
    private val context: Context?
) : RecyclerView.Adapter<ItemCategoryViewHolder?>() {
    private var selectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        val binding = ItemCategoryFoodBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {
        val category = categories.get(position)
        holder.bind(category)

        holder.itemView.setSelected(selectedPosition == position)
    }

    inner class ItemCategoryViewHolder(private val binding: ItemCategoryFoodBinding) :
        RecyclerView.ViewHolder(
            binding.getRoot()
        ) {
        init {
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    // Проверяем, что пользователь не нажал на уже выбранный элемент
                    if (getAdapterPosition() == selectedPosition) {
                        return  // Ничего не делаем
                    }

                    // 1. Сообщаем адаптеру, что старый выбранный элемент изменился (он станет серым)
                    notifyItemChanged(selectedPosition)

                    // 2. Обновляем нашу переменную, сохраняя новую выбранную позицию
                    selectedPosition = getAdapterPosition()

                    // 3. Сообщаем адаптеру, что новый выбранный элемент тоже изменился (он станет красным)
                    notifyItemChanged(selectedPosition)
                }
            })
        }

        fun bind(category: Category) {
            binding.categoryName.setText(category.getCategoryFood())
            binding.categoryIcon.setImageResource(category.icon)
        }
    }
}
