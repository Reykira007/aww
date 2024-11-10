package com.uts.babelfood;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FoodResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Food> data;

    public boolean isStatus() { return status; }
    public String getMessage() { return message; }
    public List<Food> getData() { return data; }
}
