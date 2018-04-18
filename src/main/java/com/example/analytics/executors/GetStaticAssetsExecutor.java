package com.example.analytics.executors;


import com.example.analytics.RequestExecutor;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

import static com.example.analytics.utils.Util.GSON;
import static com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse.SUCCESS_RESPONSE_CODE;
import static org.apache.commons.io.IOUtils.toByteArray;

public class GetStaticAssetsExecutor implements RequestExecutor {
    private static final String KEY = "assets";

    private String resourcePath;

    public GetStaticAssetsExecutor(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Override
    public GoPluginApiResponse execute() throws Exception {
        DefaultGoPluginApiResponse response = new DefaultGoPluginApiResponse(SUCCESS_RESPONSE_CODE);
        response.setResponseBody(GSON.toJson(Collections.singletonMap(KEY, new String(Base64.getEncoder().encode(readResource()), StandardCharsets.ISO_8859_1))));
        return response;
    }

    private byte[] readResource() throws IOException {
        return toByteArray(getClass().getResourceAsStream(resourcePath));
    }
}
