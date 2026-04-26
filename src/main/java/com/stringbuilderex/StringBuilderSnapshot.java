package com.stringbuilderex;

/**
 * Снимок состояния (Memento).
 * Хранит неизменяемую копию внутренних данных StringBuilder.
 */
public final  class StringBuilderSnapshot <T>{
    private final T state;

    /**
     * @param state строковое представление состояния для сохранения.
     */
    StringBuilderSnapshot(T state) {
        this.state = state;
    }

    /**
     * @return сохраненное состояние.
     */
    T getState() {
        return state;
    }
}
