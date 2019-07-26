package com.example.marketpulse.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import org.json.JSONArray;

import java.util.List;

public class MarketApiResponseModel
{
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String TAG = "tag";
    public static final String COLOR = "color";
    public static final String CRITERIA = "criteria";

    @SerializedName(ID)
    private int id;
    @SerializedName(NAME)
    private String name;
    @SerializedName(TAG)
    private String tag;
    @SerializedName(COLOR)
    private String color;
    @SerializedName(CRITERIA)
    private List<Criteria> criteria;

    public String getName()
    {
        return name;
    }

    public String getTag()
    {
        return tag;
    }

    public List<Criteria> getCriteria()
    {
        return criteria;
    }

    public String getColor()
    {
        return color;
    }
}
