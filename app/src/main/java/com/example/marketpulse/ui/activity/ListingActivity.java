package com.example.marketpulse.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.marketpulse.R;
import com.example.marketpulse.api.service.MarketPusleApiRequester;
import com.example.marketpulse.models.MarketApiResponseModel;
import com.example.marketpulse.ui.adapter.ListingAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class ListingActivity extends AppCompatActivity
{
    private RecyclerView _listRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _listRecyclerView = findViewById(R.id.listRecyclerView);
        _listRecyclerView.setAdapter(new ListingAdapter());
        fetchListData();
    }

    private void fetchListData()
    {
        new MarketPusleApiRequester().getData(new Callback<List<MarketApiResponseModel>>()
        {
            @Override
            public void onResponse(Call<List<MarketApiResponseModel>> call, Response<List<MarketApiResponseModel>> response)
            {
                ((ListingAdapter) _listRecyclerView.getAdapter()).setData(response.body());
            }

            @Override
            public void onFailure(Call<List<MarketApiResponseModel>> call, Throwable t)
            {

            }
        });
    }
}
