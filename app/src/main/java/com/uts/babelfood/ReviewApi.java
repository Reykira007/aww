package com.uts.babelfood;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ReviewApi {
    @FormUrlEncoded
    @POST("add_review.php")
    Call<ResponseMessage> addReview(
            @Field("id_makanan") int idMakanan,
            @Field("email") String email,
            @Field("rating") int rating,
            @Field("komentar") String komentar
    );
}
