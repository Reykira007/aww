package com.uts.babelfood;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MakananApi {
    @GET("get_makanan.php")
    Call<List<Makanan>> getMakanan();

    @GET("get_makanan.php")
    Call<List<Makanan>> getMakananByKategori(@Query("kategori") String kategori);

}

