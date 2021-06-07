package com.skifer.secondtask

/**
 * Фабрика Стеков
 */
object StackFactory{

    /**
     * Создать стек
     */
    fun <T> create(): Stack<T> = Stack()
}