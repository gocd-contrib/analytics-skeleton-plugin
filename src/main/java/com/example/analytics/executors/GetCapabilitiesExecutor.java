package com.example.analytics.executors;

import com.example.analytics.RequestExecutor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.*;

public class GetCapabilitiesExecutor implements RequestExecutor {

    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    private static final Map<String, List> CAPABILITIES_RESPONSE = new LinkedHashMap<>();
    private static final ArrayList<HashMap<String, String>> SUPPORTED_ANALYTICS = new ArrayList<>();

    static {
        SUPPORTED_ANALYTICS.add(metric("pipeline_chart", "Pipeline Chart", "pipeline"));
        SUPPORTED_ANALYTICS.add(metric("global_chart", "Dashboard Chart", "dashboard"));

        CAPABILITIES_RESPONSE.put("supported_analytics", SUPPORTED_ANALYTICS);
    }

    private static HashMap<String, String> metric(String id, String title, String type) {
        HashMap<String, String> chartMetric = new HashMap<>();

        chartMetric.put("id", id);
        chartMetric.put("title", title);
        chartMetric.put("type", type);

        return chartMetric;
    }

    @Override
    public GoPluginApiResponse execute() {
        return DefaultGoPluginApiResponse.success(GSON.toJson(CAPABILITIES_RESPONSE));
    }
}
