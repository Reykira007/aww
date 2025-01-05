package com.uts.babelfood;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InformationApi {

    @GET("get_information.php")
    Call<List<Information>> getInformation();

    @FormUrlEncoded
    @POST("add_information.php")
    Call<ResponseMessage> addInformation(
            @Field("email") String email,
            @Field("komentar") String komentar
    );
}
