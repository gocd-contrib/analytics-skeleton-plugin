package com.example.analytics.executors;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class GetPipelineChartExecutorTest {
    @Test
    public void shouldFetchPipelineChart() throws Exception {
        JSONAssert.assertEquals("{" +
                "  \"data\":\"{\\\"type\\\":\\\"pipeline\\\"}\"," +
                "  \"view_path\":\"pipeline-chart.html\"" +
                "}", new GetPipelineChartExecutor(null).execute().responseBody(), true);
    }
}