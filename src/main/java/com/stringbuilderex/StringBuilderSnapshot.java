package com.stringbuilderex;

/**
 * Снимок состояния (Memento).
 * Хранит неизменяемую копию внутренних данных StringBuilder.
 */
public final class StringBuilderSnapshot {
    private final String state;
    static final String EMPTY_STATE="";

    /**
     * @param state строковое представление состояния для сохранения.
     */
    StringBuilderSnapshot(String state) {
        this.state = state;
    }

    /**
     * @return сохраненное состояние.
     */
    String getState() {
        if(state==null){
            return EMPTY_STATE;
        }
        return state;
    }
}
