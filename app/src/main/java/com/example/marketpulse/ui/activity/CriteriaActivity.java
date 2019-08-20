package com.example.marketpulse.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.marketpulse.R;
import com.example.marketpulse.models.MarketApiResponseModel;

public class CriteriaActivity extends AppCompatActivity
{

    public static final String  ITEM_CLICKED = "itemClicked";
    public MarketApiResponseModel marketApiResponseModel;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marketApiResponseModel = ((MarketApiResponseModel) getIntent().getSerializableExtra(ITEM_CLICKED));

    }
}
