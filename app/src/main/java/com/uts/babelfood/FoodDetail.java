package com.uts.babelfood;

import com.google.gson.annotations.SerializedName;

public class FoodDetail {
    @SerializedName("id")
    private int id;

    @SerializedName("food_id")
    private int foodId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("history")
    private String history;

    @SerializedName("price_range")
    private String priceRange;

    @SerializedName("rating")
    private float rating;

    @SerializedName("total_reviews")
    private int totalReviews;

    @SerializedName("image_name")
    private String imageName;

    @SerializedName("portion_size")
    private String portionSize;

    @SerializedName("spicy_level")
    private String spicyLevel;

    @SerializedName("calories")
    private String calories;

    @SerializedName("best_time")
    private String bestTime;

    @SerializedName("ingredients")
    private String ingredients;

    @SerializedName("eating_tips")
    private String eatingTips;

    @SerializedName("accompaniment")
    private String accompaniment;

    private int imageResource;

    // Getters
    public int getId() { return id; }
    public int getFoodId() { return foodId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getHistory() { return history; }
    public String getPriceRange() { return priceRange; }
    public float getRating() { return rating; }
    public int getTotalReviews() { return totalReviews; }
    public String getImageName() { return imageName; }
    public String getPortionSize() { return portionSize; }
    public String getSpicyLevel() { return spicyLevel; }
    public String getCalories() { return calories; }
    public String getBestTime() { return bestTime; }
    public String getIngredients() { return ingredients; }
    public String getEatingTips() { return eatingTips; }
    public String getAccompaniment() { return accompaniment; }
    public int getImageResource() { return imageResource; }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
