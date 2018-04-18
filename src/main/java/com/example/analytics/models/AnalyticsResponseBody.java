package com.example.analytics.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnalyticsResponseBody {
    static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    @Expose
    @SerializedName("data")
    private String data;

    @Expose
    @SerializedName("view_path")
    private String viewPath;

    public AnalyticsResponseBody(Object data, String viewPath) {
        this.data = GSON.toJson(data);
        this.viewPath = viewPath;
    }

    public String toJson() {
        return GSON.toJson(this);
    }
}
