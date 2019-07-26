package com.example.marketpulse.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria implements Serializable
{
    public static enum CriteriaType
    {
        VARIABLE, PLAIN_TEXT

    }

    private static final String  TYPE = "type";
    private static final String TEXT  = "text";
    private static final String VARiABLE = "variable";

    @SerializedName(TYPE)
    private String type;
    @SerializedName(TEXT)
    private String text;
    @SerializedName(VARiABLE)
    private JsonObject variable = null;

    public CriteriaType getCriteriaType()
    {
        return CriteriaType.valueOf(type);
    }

    public Map<String, VariableData> getMapping()
    {
        if(variable != null)
        {
            Map<String, VariableData> variableDataMap = new HashMap<>();
            Set<Map.Entry<String, JsonElement>> entrySet = variable.entrySet();
            for(Map.Entry<String, JsonElement> entry : entrySet)
            {
                String key = entry.getKey();
                JsonObject value = entry.getValue().getAsJsonObject();
                VariableData variableData = VariableData.getVariableDataFromJson(value);
                variableDataMap.put(key, variableData);
            }
            return variableDataMap;
        }
        return null;
    }
}
