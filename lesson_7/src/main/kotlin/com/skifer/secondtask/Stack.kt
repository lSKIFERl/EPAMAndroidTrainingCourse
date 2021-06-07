package com.skifer.secondtask

/**
 * Класс очень очень очень очень странного Стека из 1 элемента
 * @param <T> Тип хранящихся значений
</T> */
class Stack<T> {
    /**
     * Элемент. Единственный и неповторимый
     */
    @Volatile private var item: T? = null

    /**
     * Положить в стек элемент [item]
     * @param item элемент
     */
    @Synchronized fun push(item: T?) {
        if(this.item == null)
            this.item = item
    }

    /**
     * Позволяет посмотреть содержимое без извлечения
     * @return item элемент
     */
    @Synchronized fun peek(): T? {
        return item
    }

    /**
     * Вытащить элемент из стека
     * @return элемент
     */
    @Synchronized fun pop(): T? {
        val item = this.item
        this.item = null
        return item
    }
}