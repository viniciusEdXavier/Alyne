package br.com.tnhg.alyneapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EndpointInterface {

    @POST("/auth/signin")
    Call<WSResponse> getAuth(@Body Auth auth);

    @POST("/v1/events")
    Call<Void> setEvento(@Body NewEvent newEvent, @Header("Authorization") String token);

    @GET("/v1/events/myevents")
    Call<Event[]> getAllEventos(@Header("Authorization") String token);

    @GET("/v1/events/")
    Call<Event[]> getProxEventos(@Header("Authorization") String token);

    @POST("/auth/signup")
    Call<Void> setUser(@Body User newUser);

    @PUT("/events/{id}/alyne")
    Call<Void> alyne(@Path("id")int id);

}
