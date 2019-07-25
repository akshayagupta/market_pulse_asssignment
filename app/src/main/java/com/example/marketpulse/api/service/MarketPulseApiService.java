package com.example.marketpulse.api.service;


import com.example.marketpulse.models.MarketApiResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MarketPulseApiService
{
    @GET("data")
    Call<MarketApiResponseModel> getData();
}
