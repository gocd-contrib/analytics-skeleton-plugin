package com.example.analytics.executors;

import com.example.analytics.models.AnalyticsResponseBody;
import com.example.analytics.requests.AnalyticsRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.HashMap;

import static com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse.SUCCESS_RESPONSE_CODE;

public class GetPipelineChartExecutor implements RequestExecutor {
    private AnalyticsRequest request;

    public GetPipelineChartExecutor(AnalyticsRequest request) {
        this.request = request;
    }

    @Override
    public GoPluginApiResponse execute() throws Exception {
        HashMap<String, String> data = new HashMap<>();
        data.put("type", "pipeline");

        AnalyticsResponseBody responseBody = new AnalyticsResponseBody(data, "pipeline-chart.html");

        return new DefaultGoPluginApiResponse(SUCCESS_RESPONSE_CODE, responseBody.toJson());
    }
}
