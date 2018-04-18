package com.example.analytics.executors;

import com.example.analytics.exceptions.UnSupportedAnalyticException;
import com.example.analytics.requests.AnalyticsRequest;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.String.format;

public class AnalyticsExecutorSelector {

    private static Map<String, Class<? extends RequestExecutor>> executors = new HashMap<>();

    static {
        executors.put("pipeline_chart", GetPipelineChartExecutor.class);
        executors.put("global_chart", GetGlobalChartExecutor.class);
    }

    public static RequestExecutor executorFor(GoPluginApiRequest request) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        AnalyticsRequest analyticsRequest = AnalyticsRequest.fromJSON(request.requestBody());

        return resolveExecutor(analyticsRequest).getConstructor(AnalyticsRequest.class).newInstance(analyticsRequest);
    }

    private static Class<? extends RequestExecutor> resolveExecutor(AnalyticsRequest analyticsRequest) {
        String metricId = analyticsRequest.getId();

        if (!executors.containsKey(metricId)) {
            throw new UnSupportedAnalyticException(format("No available analytics for metric id: %s", metricId));
        }

        return Objects.requireNonNull(executors.get(metricId), format("No executor found for metric id: %s", metricId));
    }
}

