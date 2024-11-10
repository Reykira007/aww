package com.uts.babelfood;

import com.uts.babelfood.FoodResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("popular_foods.php")
    Call<FoodResponse> getPopularFoods();

    @GET("food_detail.php")
    Call<FoodDetailResponse> getFoodDetail(@Query("id") int id);
}