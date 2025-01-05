package com.uts.babelfood;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PromoApi {
    @GET("get_promo.php")
    Call<List<Promo>> getPromo();

    @GET("get_promo.php")
    Call<List<Promo>> getPromoByKategori(@Query("kategori") String kategori);
}
