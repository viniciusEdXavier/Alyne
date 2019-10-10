package br.com.tnhg.alyneapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointInterface {

    @GET("/")
    Call<Response> getResponse();
}
