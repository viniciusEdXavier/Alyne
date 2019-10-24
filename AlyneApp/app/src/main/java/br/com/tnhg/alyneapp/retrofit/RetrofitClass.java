package br.com.tnhg.alyneapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    public static final Retrofit retrofit =new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3001/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
