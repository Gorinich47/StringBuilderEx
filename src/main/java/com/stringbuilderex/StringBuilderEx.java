package com.stringbuilderex;

/**
 * Расширенный билдер строк (Originator).
 * Предоставляет возможность отмены операций (undo) через паттерн Хранитель.
 */
public class StringBuilderEx {
    private StringBuilder sbuilder = new StringBuilder();
    private final StringBuilderHistory<StringBuilderSnapshot> history;

    /*
     Конструктор с параметром - размер истории
     */
    StringBuilderEx(int sizeHistory){
         this.history = new StringBuilderHistory<>(sizeHistory);
    }
    /*
      Дефолтовый конструкор, размер истории будет 2
     */
    StringBuilderEx() {
        this(2);
    }

    /**
     * Возвращает состояние объекта к моменту до последней модифицирующей операции.
     * @return текущий экземпляр {@link StringBuilderEx}.
     */
    public StringBuilderEx undo(){
        // Истории уже нет или еще нет
        if (history.isEmpty()) {
            return this;
        }

        // есть история и есть снимок
        StringBuilderSnapshot<String> snapshot = history.undo();
        if(history!=null){
            this.sbuilder = new StringBuilder(snapshot.getState());
        }
        return this;
    }

    /*
    Сделаю append и insert для всех примитиво и String
     */
    // Перечисляем допустимые типы:
    public StringBuilderEx append(String value)   { return appendGeneric(value); }
    public StringBuilderEx append(Integer value)   { return appendGeneric(value); }
    public StringBuilderEx append(Long value)      { return appendGeneric(value); }
    public StringBuilderEx append(Boolean value)   { return appendGeneric(value); }
    public StringBuilderEx append(Character value) { return appendGeneric(value); }
    public StringBuilderEx append(Double value)    { return appendGeneric(value); }

    // делигируем все перезагрузки метода append через обёртки
    /**
     * Добавляет строковое представление объекта.
     * Состояние перед добавлением сохраняется в историю.
     * @param value значение для добавления.
     * @return текущий экземпляр {@link StringBuilderEx}.
     */
    private <T> StringBuilderEx appendGeneric(T value) {
        history.save(new StringBuilderSnapshot<>(sbuilder.toString()));
        sbuilder.append(value);
        return this;
    }

    // Перечисляем допустимые типы:
    public StringBuilderEx insert(int offset ,String value)   { return insertGeneric(offset, value); }
    public StringBuilderEx insert(int offset ,Integer value)   { return insertGeneric(offset, value); }
    public StringBuilderEx insert(int offset ,Long value)      { return insertGeneric(offset, value); }
    public StringBuilderEx insert(int offset ,Boolean value)   { return insertGeneric(offset, value); }
    public StringBuilderEx insert(int offset ,Character value) { return insertGeneric(offset, value); }
    public StringBuilderEx insert(int offset ,Double value)    { return insertGeneric(offset, value); }

    /**
     * Вставляет строковое представление объекта.
     * Состояние перед добавлением сохраняется в историю.
     * @param value значение для добавления.
     * @return текущий экземпляр {@link StringBuilderEx}.
     */
    <T> StringBuilderEx insertGeneric(int offset , T value){
        history.save(new StringBuilderSnapshot<>(sbuilder.toString()));
        sbuilder.insert(offset, value);
        return this;
    }

    // Остальные без перегрузок

    StringBuilderEx delete(int start, int end) {
        history.save(new StringBuilderSnapshot<>(sbuilder.toString()));
        sbuilder.delete(start, end);
        return this;
    }

    StringBuilderEx deleteCharAt(int index) {
        history.save(new StringBuilderSnapshot<>(sbuilder.toString()));
        sbuilder.deleteCharAt(index);
        return this;
    }

    StringBuilderEx replace(int start, int end, String str) {
        history.save(new StringBuilderSnapshot<>(sbuilder.toString()));
        sbuilder.replace(start, end, str);
        return this;
    }
    StringBuilderEx reverse() {
        history.save(new StringBuilderSnapshot<>(sbuilder.toString()));
        sbuilder.reverse();
        return this;
    }

    public String toString () {
        return sbuilder.toString();
    }
}
