package com.example.marketpulse.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance
{
    private static RetrofitClientInstance retrofitClientInstance;
    private Retrofit retrofit;
    private static String BASE_URL = "https://mp-android-challenge.herokuapp.com/";

    public static RetrofitClientInstance getInstance()
    {
        if(retrofitClientInstance == null)
        {
            retrofitClientInstance = new RetrofitClientInstance();
            retrofitClientInstance.initializeRetrofit();
        }
        return retrofitClientInstance;
    }

    private void initializeRetrofit()
    {
        retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL).
                        addConverterFactory(GsonConverterFactory.create()).
                        build();
    }

    public <T> T createService(Class<T> serviceClass) {
        return  retrofit.create(serviceClass);
    }

}
