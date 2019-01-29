package com.ranqk.damon.explore_java_android.extra;

public enum Extra {
    CROSS_METHOD_INVOKE("display_message_activity");

    private String key;

    Extra(String message) {
        this.key = "com.ranqk.damon.explore_java_explore.intent." + message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
