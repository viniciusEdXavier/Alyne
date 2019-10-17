package br.com.tnhg.alyneapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndpointInterface {

    @GET("/")
    Call<Response> getResponse();

    @POST("/auth/signin")
    Call<Response> getAuth(@Body Auth auth);
}
