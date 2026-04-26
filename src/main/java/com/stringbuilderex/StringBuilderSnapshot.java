package com.stringbuilderex;

public final class Snapshot {
    private final String state;

    private Snapshot(String state) {
        this.state = state;
    }

    // Доступ к состоянию только для владельца (StringBuilderEx)
    private String getState() {
        return state;
    }
}
