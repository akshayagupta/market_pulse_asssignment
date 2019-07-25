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
    public void getData()
    {
        MarketPulseApiService marketPulseApiService = RetrofitClientInstance.getInstance().createService(MarketPulseApiService.class);
        Call<List<MarketApiResponseModel>> call = marketPulseApiService.getData();
        call.enqueue(new Callback<List<MarketApiResponseModel>>()
        {
            @Override
            public void onResponse(Call<List<MarketApiResponseModel>> call, Response<List<MarketApiResponseModel>> response)
            {
                Log.d("akshay" , "success respone");
            }

            @Override
            public void onFailure(Call<List<MarketApiResponseModel>> call, Throwable t)
            {
                Log.d("akshay" , "failure respone");
            }
        });
    }
}
