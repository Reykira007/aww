package com.uts.babelfood;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.uts.babelfood.databinding.ActivityFoodDetailBinding;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodDetailActivity extends AppCompatActivity {
    private ActivityFoodDetailBinding binding;
    private int foodId;

    private static final Map<String, Integer> FOOD_IMAGES = new HashMap<>();
    static {
        FOOD_IMAGES.put("img_lempah_kuning", R.drawable.img_lempah);
        FOOD_IMAGES.put("img_mie_koba", R.drawable.img_mikoba);
        FOOD_IMAGES.put("img_rusip", R.drawable.img_rusip);
        FOOD_IMAGES.put("img_lakso", R.drawable.img_lakso);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        foodId = getIntent().getIntExtra("food_id", -1);
        if (foodId == -1) {
            Toast.makeText(this, "Invalid food id", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setupViews();
        loadFoodDetail();
    }

    private void setupViews() {
        binding.btnBack.setOnClickListener(v -> finish());
    }

    private void showLoading() {
        binding.loadingLayout.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        binding.loadingLayout.setVisibility(View.GONE);
    }

    private void loadFoodDetail() {
        showLoading();
        url.getApiService().getFoodDetail(foodId).enqueue(new Callback<FoodDetailResponse>() {
            @Override
            public void onResponse(Call<FoodDetailResponse> call, Response<FoodDetailResponse> response) {
                hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    FoodDetailResponse detailResponse = response.body();
                    if (detailResponse.isStatus() && detailResponse.getData() != null
                            && detailResponse.getData().length > 0) {
                        FoodDetail foodDetail = detailResponse.getData()[0];
                        displayFoodDetail(foodDetail);
                        Toast.makeText(FoodDetailActivity.this,
                                "Data detail berhasil diambil", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(FoodDetailActivity.this,
                                "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(FoodDetailActivity.this,
                            "Gagal memuat data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FoodDetailResponse> call, Throwable t) {
                hideLoading();
                Toast.makeText(FoodDetailActivity.this,
                        "Error koneksi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayFoodDetail(FoodDetail food) {
        try {
            Integer resourceId = FOOD_IMAGES.get(food.getImageName());
            binding.ivFoodDetail.setImageResource(resourceId != null ? resourceId : R.drawable.img_lakso);

            binding.tvFoodName.setText(food.getName());
            binding.tvRating.setText(String.format("%.1f", food.getRating()));
            binding.tvTotalReviews.setText(String.format("(%d reviews)", food.getTotalReviews()));
            binding.tvPrice.setText(food.getPriceRange());

            binding.tvDescription.setText(food.getDescription());
            binding.tvHistory.setText(food.getHistory());

            binding.tvPortion.setText(food.getPortionSize());
            binding.tvSpicyLevel.setText(food.getSpicyLevel());
            binding.tvCalories.setText(food.getCalories());
            binding.tvBestTime.setText(food.getBestTime());

            binding.tvIngredients.setText(food.getIngredients());
            binding.tvEatingTips.setText(food.getEatingTips());
            binding.tvAccompaniment.setText(food.getAccompaniment());

        } catch (Exception e) {
            Toast.makeText(this, "Error menampilkan data: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}