package com.vacral.foodapplycation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide; // Эта строка пока будет гореть красным
import com.vacral.foodapplycation.databinding.ItemFoodBinding;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private final List<Food> foodList;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFoodBinding binding = ItemFoodBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(foodList.get(position));
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        private final ItemFoodBinding binding;

        public FoodViewHolder(ItemFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Food food) {
            binding.tvFoodName.setText(food.getTitle());
            binding.foodPrice.setText(food.getPrice());
            binding.RatingBar.setRating(food.getRating());

            // Используем библиотеку Glide для загрузки картинки
            Glide.with(itemView.getContext())
                    .load(food.getPic())
                    .into(binding.tvFood); // tvFood - это ID вашего ImageView
        }
    }
}