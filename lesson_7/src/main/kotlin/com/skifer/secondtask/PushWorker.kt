package com.skifer.secondtask

/**
 * Класс для вложения элементов в стек
 */
class PushWorker<T>(
    /**
     * Стек
     */
    private val stack: Stack<T?>?
) {
    /**
     * Кладём элемент в стек
     * @param item элемент
     */
    fun push(item: T) {
        stack?.push(item)
    }
}