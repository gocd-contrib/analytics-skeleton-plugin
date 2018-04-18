"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});

/* A stub for the plugin endpoint which will be available at runtime. */
var PluginEndpoint = function PluginEndpoint() {
    return {
        ensure: function ensure() {},
        on: function on() {},
        define: function define() {},
        init: function init() {},
        onInit: function onInit() {}
    };
};

exports.default = new PluginEndpoint();
