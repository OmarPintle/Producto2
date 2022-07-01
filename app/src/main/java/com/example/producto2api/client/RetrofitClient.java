package com.example.producto2api.client;

import  retrofit2.Retrofit;

import com.example.producto2api.service.RetrofitApiService;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String URL_BASE = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit;

    public static RetrofitApiService getApiService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitApiService.class);
    }
}
