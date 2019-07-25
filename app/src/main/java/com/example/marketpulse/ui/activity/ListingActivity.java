package com.example.marketpulse.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.example.marketpulse.R;

public class ListingActivity extends AppCompatActivity
{
    private RecyclerView _listRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _listRecyclerView = findViewById(R.id.listRecyclerView);
    }
}
