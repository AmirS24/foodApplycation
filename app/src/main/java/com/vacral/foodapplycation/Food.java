package com.vacral.foodapplycation;

public class Food {
    private String title;
    private String price;
    private int pic;
    private float rating;

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public int getPic() {
        return pic;
    }

    public float getRating() {
        return rating;
    }

    public Food(String title, float rating, int pic, String price) {
        this.title = title;
        this.rating = rating;
        this.pic = pic;
        this.price = price;
    }
}
