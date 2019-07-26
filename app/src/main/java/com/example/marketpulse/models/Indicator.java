package com.example.marketpulse.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONObject;

public class Indicator
{
    private String studyType;
    private String parameter_name;
    private int minValue;
    private int maxValue;
    private int defaultValue;

    public Indicator(String studyType, String parameter_name, int minValue, int maxValue, int defaultValue)
    {
        this.studyType = studyType;
        this.parameter_name = parameter_name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.defaultValue = defaultValue;
    }

    public static Indicator getIndicatorFromJson(JsonObject jsonObject)
    {
        try
        {
            String studyType = jsonObject.get("study_type").getAsString();
            String parameterName = jsonObject.get("parameter_name").getAsString();
            int minValue = jsonObject.get("min_value").getAsInt();
            int maxValue = jsonObject.get("max_value").getAsInt();
            int defautValue = jsonObject.get("default_value").getAsInt();
            Indicator indicator = new Indicator(studyType, parameterName, minValue, maxValue, defautValue);
            return indicator;
        } catch (Exception exception)
        {

        }
        return null;
    }
}
