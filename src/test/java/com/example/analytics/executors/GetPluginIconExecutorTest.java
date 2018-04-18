package com.example.analytics.executors;

import com.example.analytics.utils.Util;
import com.google.common.io.BaseEncoding;
import com.google.gson.Gson;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GetPluginIconExecutorTest {
    @Test
    public void rendersIconInBase64() throws Exception {
        GoPluginApiResponse response = new GetPluginIconExecutor().execute();
        HashMap<String, String> hashMap = new Gson().fromJson(response.responseBody(), HashMap.class);
        assertThat(hashMap.size(), is(2));
        assertThat(hashMap.get("content_type"), is("image/svg+xml"));
        System.out.println("hashMap = " + hashMap.get("data"));
        assertThat(Util.readResourceBytes("/plugin-icon.svg"), is(BaseEncoding.base64().decode(hashMap.get("data"))));
    }
}