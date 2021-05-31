package com.skifer.secondtask

/**
 * Класс очень очень очень очень странного Стека из 1 элемента
 * @param <T> Тип хранящихся значений
</T> */
class Stack<T> {
    /**
     * Элемент. Единственный и неповторимый
     */
    private var item: T? = null

    /**
     * Положить в стек элемент
     * @param item элемент
     */
    fun push(item: T?) {
        if(this.item == null)
            this.item = item
    }

    /**
     * Позволяет посмотреть содержимое без извлечения
     */
    fun peek (): T? {
        return item
    }

    /**
     * Вытащить элемент из стека
     * @return элемент
     */
    fun pop(): T? {
        val item = this.item
        this.item = null
        return item
    }
}