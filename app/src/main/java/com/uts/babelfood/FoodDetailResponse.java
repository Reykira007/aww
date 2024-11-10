package com.uts.babelfood;

import com.google.gson.annotations.SerializedName;

public class FoodDetailResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private FoodDetail[] data;

    public boolean isStatus() { return status; }
    public String getMessage() { return message; }
    public FoodDetail[] getData() { return data; }
}
