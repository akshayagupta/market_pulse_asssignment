package com.example.marketpulse.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class VariableData
{

    public enum  VariableType
    {
        VALUE, INDICATOR;

        static VariableType fromString(String string)
        {
            if(string.equalsIgnoreCase("value"))
            {
                return VALUE;
            } else{
                return INDICATOR;
            }
        }
    }

    private VariableType variableType;
    private List<Integer> values;
    private Indicator indicator;

    public VariableData(List<Integer> values)
    {
        variableType = VariableType.VALUE;
        this.values = values;
    }

    public VariableData(Indicator indicator)
    {
        variableType = VariableType.INDICATOR;
        this.indicator = indicator;
    }

    public static VariableData getVariableDataFromJson(JsonObject jsonObject)
    {

        VariableData variableData = null;
        try
        {
            String type = jsonObject.getAsJsonPrimitive("type").getAsString();
            VariableType variableType = VariableType.fromString(type);
            if(variableType == VariableType.INDICATOR)
            {
                Indicator indicator = Indicator.getIndicatorFromJson(jsonObject);
                variableData = new VariableData( indicator);
            } else if(variableType == VariableType.VALUE)
            {
                JsonArray jsonArray = jsonObject.getAsJsonArray("values");
                List<Integer> integers = new ArrayList<>();
                for(int i =0 ; i < jsonArray.size(); i++)
                {
                    integers.add(jsonArray.get(0).getAsInt());
                }
                variableData = new VariableData(integers);
            }
            return variableData;
        }catch (Exception exception)
        {

        }
        return null;
    }
}
