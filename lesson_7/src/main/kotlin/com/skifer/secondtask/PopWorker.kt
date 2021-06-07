package com.skifer.secondtask

/**
 * Класс для извеления предмета из стека
 */
class PopWorker<T>(
    /**
     * Стек
     */
    private val stack: Stack<T?>?
) {

    /**
     * Позволяет посмотреть содержимое без извлечения
     */
    fun peek(): T? {
        return stack?.peek()
    }
    /**
     * Извлчение предмета
     * @return предмет
     */
    fun pop(): T? {
        return stack?.pop()
    }
}