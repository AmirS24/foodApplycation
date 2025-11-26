package com.vacral.foodapplycation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vacral.foodapplycation.databinding.ItemCategoryFoodBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemCategoryViewHolder> {
    private final List<Category> categories;
    private final Context context;

public CategoryAdapter(List<Category> categories, Context context){
    this.categories = categories;
    this.context = context;
}

   public ItemCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryFoodBinding binding = ItemCategoryFoodBinding.inflate(LayoutInflater.from(context), parent, false);
return new ItemCategoryViewHolder(binding);}
    @Override
    public int getItemCount() {
      return  categories.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCategoryViewHolder holder, int position) {
Category category = categories.get(position);
holder.bind(category);
    }

    public class ItemCategoryViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryFoodBinding binding;
        public ItemCategoryViewHolder(ItemCategoryFoodBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
        public void bind(Category category){
    binding.categoryName.setText(category.getCategoryFood());
    binding.categoryIcon.setImageResource(category.getIcon());
        }
    }
}
