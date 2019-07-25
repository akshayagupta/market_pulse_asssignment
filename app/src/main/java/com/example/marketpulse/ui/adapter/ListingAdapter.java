package com.example.marketpulse.ui.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.marketpulse.R;
import com.example.marketpulse.models.MarketApiResponseModel;

import java.util.List;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListViewHolder>
{
    List<MarketApiResponseModel> marketApiResponseModels;

    public void setData(List<MarketApiResponseModel> marketApiResponseModels)
    {
        this.marketApiResponseModels = marketApiResponseModels;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listing_item,viewGroup,false);
        ListViewHolder  listViewHolder = new ListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i)
    {
        MarketApiResponseModel marketApiResponseModel = marketApiResponseModels.get(i);
        listViewHolder.getListingName().setText(marketApiResponseModel.getName());
        listViewHolder.getListingTagView().setText(marketApiResponseModel.getTag());
        if(marketApiResponseModel.getColor().equalsIgnoreCase("green"))
        {
            listViewHolder.getListingTagView().setTextColor(Color.GREEN);
        } else if(marketApiResponseModel.getColor().equalsIgnoreCase("red"))
        {
            listViewHolder.getListingTagView().setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount()
    {
        if(marketApiResponseModels != null)
        {
            return marketApiResponseModels.size();
        }
        return 0;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder
    {
        private TextView _listingNameView;
        private TextView _listingTagView;

        public ListViewHolder(View view)
        {
            super(view);
            _listingNameView = view.findViewById(R.id.listing_name);
            _listingTagView = view.findViewById(R.id.listing_tag);
        }

        public TextView getListingName()
        {
            return _listingNameView;
        }

        public TextView getListingTagView()
        {
            return _listingTagView;
        }
    }
}
