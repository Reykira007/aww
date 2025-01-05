package com.uts.babelfood;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OrderApi {
    @FormUrlEncoded
    @POST("add_order.php")
    Call<ResponseMessage> addOrder(
            @Field("id_makanan") int idMakanan,
            @Field("email") String email,
            @Field("jumlah") int jumlah,
            @Field("total_harga") double totalHarga
    );
}
