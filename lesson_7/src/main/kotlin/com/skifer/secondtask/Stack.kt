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
        while (this.item != null) {
            Thread.yield()
        }
            this.item = item
    }

    /**
     * Позволяет посмотреть содержимое без извлечения
     * @return item элемент
     */
    fun peek(): T? {
        return item
    }

    /**
     * Вытащить элемент из стека
     * @return элемент
     */
    @Synchronized fun pop(): T? {
        while (this.item == null) {
            Thread.yield()
        }
        val item = this.item
        println("Поток " + Thread.currentThread().name + " Вытащил " + item)
        this.item = null
        return item
    }
}