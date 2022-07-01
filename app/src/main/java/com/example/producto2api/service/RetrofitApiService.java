package com.example.producto2api.service;

import com.example.producto2api.entity.Message;

import retrofit2.Call;
import  retrofit2.http.GET;
import retrofit2.http.Part;

public interface RetrofitApiService {
    @GET("post/{id}")
    Call<Message> getMessageId(@Part("id") int id);
}
