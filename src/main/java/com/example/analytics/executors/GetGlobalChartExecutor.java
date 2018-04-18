package com.example.analytics.executors;

import com.example.analytics.models.AnalyticsResponseBody;
import com.example.analytics.requests.AnalyticsRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.HashMap;

import static com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse.SUCCESS_RESPONSE_CODE;

public class GetGlobalChartExecutor implements RequestExecutor {
    private AnalyticsRequest analyticsRequest;

    public GetGlobalChartExecutor(AnalyticsRequest analyticsRequest) {
        this.analyticsRequest = analyticsRequest;
    }

    @Override
    public GoPluginApiResponse execute() throws Exception {
        HashMap<String, String> data = new HashMap<>();
        data.put("type", "global");

        AnalyticsResponseBody responseBody = new AnalyticsResponseBody(data, "global-chart.html");

        return new DefaultGoPluginApiResponse(SUCCESS_RESPONSE_CODE, responseBody.toJson());
    }
}
