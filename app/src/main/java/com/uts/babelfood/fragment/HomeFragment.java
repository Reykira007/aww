package com.uts.babelfood.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.uts.babelfood.Food;
import com.uts.babelfood.FoodAdapter;
import com.uts.babelfood.FoodDetailActivity;
import com.uts.babelfood.FoodResponse;
import com.uts.babelfood.R;
import com.uts.babelfood.databinding.FragmentHomeBinding;
import com.uts.babelfood.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements FoodAdapter.OnFoodClickListener {
    private FragmentHomeBinding binding;
    private FoodAdapter foodAdapter;
    private List<Food> foodList = new ArrayList<>();

    private static final Map<String, Integer> FOOD_IMAGES = new HashMap<>();
    static {
        FOOD_IMAGES.put("img_lempah_kuning", R.drawable.img_lempah);
        FOOD_IMAGES.put("img_mie_koba", R.drawable.img_mikoba);
        FOOD_IMAGES.put("img_rusip", R.drawable.img_rusip);
        FOOD_IMAGES.put("img_lakso", R.drawable.img_lakso);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        setupRecyclerView();
        loadPopularFoods();
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        binding.rvPopular.setLayoutManager(layoutManager);
        foodAdapter = new FoodAdapter(foodList, this);
        binding.rvPopular.setAdapter(foodAdapter);
    }

    private void loadPopularFoods() {
        url.getApiService().getPopularFoods().enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    FoodResponse foodResponse = response.body();
                    if (foodResponse.isStatus() && foodResponse.getData() != null) {
                        foodList.clear();
                        List<Food> foods = foodResponse.getData();
                        for (Food food : foods) {
                            Integer resourceId = FOOD_IMAGES.get(food.getImageName());
                            food.setImageResource(resourceId != null ? resourceId : R.drawable.img_lakso);
                            foodList.add(food);
                        }
                        foodAdapter.notifyDataSetChanged();

                        Toast.makeText(getContext(), "Data berhasil diambil", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showError("Failed to load data");
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                showError("Network error: " + t.getMessage());
            }
        });
    }

    private void showError(String message) {
        if (getContext() != null) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFoodClick(Food food) {
        navigateToFoodDetail(food.getId());
    }

    private void navigateToFoodDetail(int foodId) {
        Intent intent = new Intent(requireContext(), FoodDetailActivity.class);
        intent.putExtra("food_id", foodId);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}