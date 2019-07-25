package com.example.marketpulse.api;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

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
                        client(getOkHttpClient()).
                        addConverterFactory(GsonConverterFactory.create()).
                        build();
    }

    public OkHttpClient getOkHttpClient()
    {
        Interceptor interceptor = new Interceptor()
        {
            @Override
            public Response intercept(Chain chain) throws IOException
            {
                Request request = chain.request().
                        newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build();

                return chain.proceed(request);
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        return builder.build();
    }

    public <T> T createService(Class<T> serviceClass) {
        return  retrofit.create(serviceClass);
    }

}
