package com.example.analytics.executors;


import com.example.analytics.RequestExecutor;
import com.example.analytics.utils.Util;
import com.google.common.io.BaseEncoding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

public class GetPluginIconExecutor implements RequestExecutor {
    private static final Gson GSON = new Gson();

    @Override
    public GoPluginApiResponse execute() throws Exception {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content_type", "image/svg+xml");
        jsonObject.addProperty("data", BaseEncoding.base64().encode(Util.readResourceBytes("/plugin-icon.svg")));
        DefaultGoPluginApiResponse defaultGoPluginApiResponse = new DefaultGoPluginApiResponse(200, GSON.toJson(jsonObject));
        return defaultGoPluginApiResponse;

    }
}