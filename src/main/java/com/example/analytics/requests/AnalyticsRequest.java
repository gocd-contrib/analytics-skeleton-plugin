package com.example.analytics.requests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class AnalyticsRequest {
    private static final Gson GSON = new GsonBuilder().
            excludeFieldsWithoutExposeAnnotation().
            create();

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("params")
    private Map<String, String> params;

    public AnalyticsRequest() {
    }

    public AnalyticsRequest(String type, String id, Map<String, String> params) {
        this.type = type;
        this.params = params;
    }

    public static AnalyticsRequest fromJSON(String json) {
        return GSON.fromJson(json, AnalyticsRequest.class);
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "AnalyticsRequest{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", params=" + params +
                '}';
    }
}
