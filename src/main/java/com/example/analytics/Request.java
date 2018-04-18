/*
 * Copyright 2018 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.analytics;

/**
 * Enumerable that represents one of the messages that the server sends to the plugin
 */
public enum Request {
    REQUEST_GET_PLUGIN_ICON(Constants.REQUEST_PREFIX + ".get-icon"),
    REQUEST_GET_CAPABILITIES(Constants.REQUEST_PREFIX + ".get-capabilities"),
    REQUEST_GET_ANALYTICS(Constants.REQUEST_PREFIX + ".get-analytics"),
    REQUEST_GET_STATIC_ASSETS(Constants.REQUEST_PREFIX + ".get-static-assets"),

    PLUGIN_SETTINGS_GET_CONFIGURATION(Constants.GO_PLUGIN_SETTINGS_PREFIX + ".get-configuration"),
    PLUGIN_SETTINGS_VALIDATE_CONFIGURATION(Constants.GO_PLUGIN_SETTINGS_PREFIX + ".validate-configuration"),
    PLUGIN_SETTINGS_GET_VIEW(Constants.GO_PLUGIN_SETTINGS_PREFIX + ".get-view"),
    PLUGIN_SETTINGS_CHANGE_NOTIFICATION(Constants.GO_PLUGIN_SETTINGS_PREFIX + ".plugin-settings-changed");

    private final String requestName;

    Request(String requestName) {
        this.requestName = requestName;
    }

    public static Request fromString(String requestName) {
        if (requestName != null) {
            for (Request request : Request.values()) {
                if (requestName.equalsIgnoreCase(request.requestName)) {
                    return request;
                }
            }
        }

        return null;
    }

    public String requestName() {
        return requestName;
    }

    private static class Constants {
        public static final String REQUEST_PREFIX = "go.cd.analytics";
        public static final String GO_PLUGIN_SETTINGS_PREFIX = "go.plugin-settings";
    }
}
