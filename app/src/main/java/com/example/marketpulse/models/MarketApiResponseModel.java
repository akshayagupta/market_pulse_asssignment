package com.example.marketpulse.models;

import com.google.gson.annotations.SerializedName;

public class MarketApiResponseModel
{
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String TAG = "tag";
    public static final String COLOR = "color";

    @SerializedName(ID)
    private int id;
    @SerializedName(NAME)
    private String name;
    @SerializedName(TAG)
    private String tag;
    @SerializedName(COLOR)
    private String color;

}
