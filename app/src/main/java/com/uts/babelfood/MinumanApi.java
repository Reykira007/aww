package com.uts.babelfood;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MinumanApi {
    @GET("get_minuman.php")
    Call<List<Minuman>> getMinuman();

    @GET("get_minuman.php")
    Call<List<Minuman>> getMinumanByKategori(@Query("kategori") String kategori);
}
