package com.example.task.Network;

import com.example.task.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient retrofitClient = null;

    public static RetrofitClient getInstance() {
        return new RetrofitClient();
    }

    Retrofit getRetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkhttpClient())
                .build();
        return retrofit;
    }

    public ApiService getApiService(){
       return getRetrofitClient().create(ApiService.class);
    }

    public OkHttpClient getOkhttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        return builder.build();
    }
}
