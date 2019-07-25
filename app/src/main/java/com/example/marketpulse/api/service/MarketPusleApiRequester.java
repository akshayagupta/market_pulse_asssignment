package com.example.marketpulse.api.service;

import android.util.Log;
import com.example.marketpulse.api.RetrofitClientInstance;
import com.example.marketpulse.models.MarketApiResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MarketPusleApiRequester
{
    public void getData(Callback<List<MarketApiResponseModel>> callback)
    {
        MarketPulseApiService marketPulseApiService = RetrofitClientInstance.getInstance().createService(MarketPulseApiService.class);
        Call<List<MarketApiResponseModel>> call = marketPulseApiService.getData();
        call.enqueue(callback);
    }
}
