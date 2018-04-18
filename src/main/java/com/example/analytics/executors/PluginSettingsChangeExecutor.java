package com.example.analytics.executors;

import com.example.analytics.PluginSettings;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

public class PluginSettingsChangeExecutor implements RequestExecutor {
    private PluginSettings pluginSettings;

    public PluginSettingsChangeExecutor(PluginSettings pluginSettings) {
        this.pluginSettings = pluginSettings;
    }

    @Override
    public GoPluginApiResponse execute() {
        //todo: Perform any required cleanup on plugin settings change
        return DefaultGoPluginApiResponse.success("");
    }
}
