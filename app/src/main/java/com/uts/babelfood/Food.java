package com.uts.babelfood;

import com.google.gson.annotations.SerializedName;

public class Food {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("rating")
    private float rating;

    @SerializedName("image_name")
    private String imageName;

    private int imageResource;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public float getRating() { return rating; }
    public String getImageName() { return imageName; }
    public int getImageResource() { return imageResource; }
    public void setImageResource(int imageResource) { this.imageResource = imageResource; }
}