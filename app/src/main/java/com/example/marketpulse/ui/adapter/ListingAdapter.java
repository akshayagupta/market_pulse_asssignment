package com.example.marketpulse.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.marketpulse.R;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListViewHolder>
{
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

    }

    @Override
    public int getItemCount()
    {
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

        public TextView get_listingTagView()
        {
            return _listingTagView;
        }
    }
}
