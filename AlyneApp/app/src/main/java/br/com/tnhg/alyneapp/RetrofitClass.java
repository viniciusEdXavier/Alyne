package br.com.tnhg.alyneapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    static final Retrofit retrofit =new Retrofit.Builder()
            .baseUrl("http://10.20.23.31:3001/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
