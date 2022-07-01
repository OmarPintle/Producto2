package com.example.producto2api;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.producto2api.client.RetrofitClient;
import com.example.producto2api.databinding.ActivityMainBinding;
import com.example.producto2api.entity.Message;
import com.example.producto2api.service.RetrofitApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;
    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initValues();
        getMessage(49);
    }

    private void initView(){
        mTextView = binding.messageTextView;
    }

    private void initValues(){
        apiService = RetrofitClient.getApiService();
    }
    private void  getMessage(int id){
        apiService.getMessageId(id).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                mTextView.setText(message.toString());
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                mTextView.setText(t.getMessage());

            }
        });
    }


}