package com.uts.babelfood;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ResepApi {
    @FormUrlEncoded
    @POST("add_resep.php")
    Call<ResponseMessage> addResep(
            @Field("nama_resep") String namaResep,
            @Field("deskripsi") String deskripsi,
            @Field("bahan") String bahan,
            @Field("langkah_persiapan") String langkahPersiapan,
            @Field("waktu_persiapan") int waktuPersiapan,
            @Field("tingkat_kesulitan") String tingkatKesulitan,
            @Field("gambar") String gambar
    );
}
