package com.skifer.secondtask

/**
 * Фабрика Стеков
 * @param <T>
</T> */
class StackFactory<T> {

    /**
     * Хранимый стек
     */
    var stack: Stack<T>? = null

    /**
     * Создать стек
     */
    fun createStack() {
        stack = Stack()
    }
}