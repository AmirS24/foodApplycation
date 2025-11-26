package com.vacral.foodapplycation;

public class Category {
    private String CategoryFood;
    private int icon;

    public Category(String categoryFood, int icon) {
        CategoryFood = categoryFood;
        this.icon = icon;
    }

    public String getCategoryFood() {
        return CategoryFood;
    }

    public void setCategoryFood(String categoryFood) {
        CategoryFood = categoryFood;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
