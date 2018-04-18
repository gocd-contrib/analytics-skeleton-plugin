package com.example.analytics.executors;

import com.example.analytics.exceptions.UnSupportedAnalyticException;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AnalyticsExecutorSelectorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private GoPluginApiRequest request;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void executorForPipelineMetric() throws Exception {
        when(request.requestBody()).thenReturn("{\"type\": \"pipeline\", \"id\": \"pipeline_chart\"}");

        assertTrue(AnalyticsExecutorSelector.executorFor(request) instanceof GetPipelineChartExecutor);
    }

    @Test
    public void executorForGlobalMetric() throws Exception {
        when(request.requestBody()).thenReturn("{\"type\": \"pipeline\", \"id\": \"global_chart\"}");

        assertTrue(AnalyticsExecutorSelector.executorFor(request) instanceof GetGlobalChartExecutor);
    }

    @Test(expected = UnSupportedAnalyticException.class)
    public void executorForThrowsErrorOnUnknownType() throws Exception {
        when(request.requestBody()).thenReturn("{\"type\": \"dunno\", \"id\": \"un_supported\"}");
        AnalyticsExecutorSelector.executorFor(request);
    }
}