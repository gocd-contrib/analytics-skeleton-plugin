package com.example.analytics.executors;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class GetCapabilitiesExecutorTest {

    @Test
    public void shouldGetPluginCapabilities() throws Exception {
        JSONAssert.assertEquals("{" +
                "  \"supported_analytics\":[" +
                "    {" +
                "      \"id\":\"pipeline_chart\"," +
                "      \"title\":\"Pipeline Chart\"," +
                "      \"type\":\"pipeline\"}," +
                "    {" +
                "      \"id\":\"global_chart\"," +
                "      \"title\":\"Dashboard Chart\"," +
                "      \"type\":\"dashboard\"}" +
                "  ]" +
                "}", new GetCapabilitiesExecutor().execute().responseBody(), true);
    }
}