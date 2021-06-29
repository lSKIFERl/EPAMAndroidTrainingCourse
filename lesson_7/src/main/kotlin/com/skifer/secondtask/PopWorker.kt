package com.skifer.secondtask

import java.util.concurrent.Callable

/**
 * Класс для извеления предмета из стека
 */
class PopWorker<T>(
    /**
     * Стек
     */
    private val stack: Stack<T?>?
): Runnable {

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

    override fun run() {
        Thread.currentThread().name = "PopWorker"
        while (!Thread.currentThread().isInterrupted) {
            pop()
        }
    }
}