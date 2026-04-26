package com.stringbuilderex;

import java.util.LinkedList;

/**
 * Опекун (Caretaker).
 * Отвечает за хранение истории снимков и соблюдение лимита памяти.
 * можно использовать доля разных объектов
 */
public  class StringBuilderHistory<T> {
    private final LinkedList<T> history = new LinkedList<>();
    private final int maxSteps; // Максимальное количество шагов отката

    /**
     * @param maxSteps максимальное количество шагов отмены.
     */
    public StringBuilderHistory(int maxSteps) {
        this.maxSteps = maxSteps;
    }

    /**
     * Добавляет снимок в историю. При превышении лимита старые снимки удаляются.
     * @param  originater {@link T} объект снимка.
     */
    public void save(T originater){
        if (history.size() >= maxSteps) {
            history.removeLast(); // Удаляем самый старый снимок
        }
        history.addFirst(originater);
    }

    /*
     Восстанавливаем последнее сохраненное значение
     не буду реализовывать возврат к состоянию до отката
     т.е. перемещение по списку вперед и назад
     */
    /**
     * Извлекает последний снимок из истории.
     * @return последний {@link T} или {@code null}, если история пуста.
     */
     public T undo(){
        if(!history.isEmpty()){
            return history.pollFirst(); // Извлекаем первый элемент
            //history.removeFirst(); // теперь удалим его, т.к. использовали его
        } else{
           return null;
        }
    }

    /**
     * Проверяет наличие элементов в списке
     * @return {@code true },если список содержит элементы
     */
    public boolean isEmpty(){
         return history.isEmpty();
    }
}
