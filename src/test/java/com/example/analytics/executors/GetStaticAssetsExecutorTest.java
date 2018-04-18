package com.example.analytics.executors;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

public class GetStaticAssetsExecutorTest {
    @Test
    public void shouldSendBase64Payload() throws Exception {
        GetStaticAssetsExecutor executor = new GetStaticAssetsExecutor("/hello.txt");
        String expected = Base64.getEncoder().encodeToString("hi there!".getBytes(StandardCharsets.ISO_8859_1));
        assertEquals(String.format("{\"assets\":\"%s\"}", expected), executor.execute().responseBody());
    }
}