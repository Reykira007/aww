package com.uts.babelfood;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RequestMenuApi {

    @FormUrlEncoded
    @POST("add_request_menu.php")
    Call<ResponseMessage> addRequestMenu(
            @Field("nama_menu") String namaMenu,
            @Field("deskripsi_menu") String deskripsiMenu,
            @Field("jenis_menu") String jenisMenu,
            @Field("email_pengguna") String emailPengguna,
            @Field("perkiraan_harga") double perkiraanHarga,
            @Field("alasan_request") String alasanRequest,
            @Field("gambar_referensi") String gambarReferensi
    );
}
