package com.example.analytics.executors;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class GetGlobalChartExecutorTest {
    @Test
    public void shouldFetchGlobalChart() throws Exception {
        JSONAssert.assertEquals("{" +
                "  \"data\":\"{\\\"type\\\":\\\"global\\\"}\"," +
                "  \"view_path\":\"global-chart.html\"" +
                "}", new GetGlobalChartExecutor(null).execute().responseBody(), true);
    }
}