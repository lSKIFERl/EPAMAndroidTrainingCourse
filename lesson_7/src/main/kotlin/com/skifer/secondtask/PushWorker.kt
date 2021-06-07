package com.skifer.secondtask

import java.util.concurrent.Callable
import kotlin.random.Random

/**
 * Класс для вложения элементов в стек
 */
class PushWorker<T>(
    /**
     * Стек
     */
    private val stack: Stack<T?>?,
    private val item: T
): Runnable {
    /**
     * Кладём элемент в стек
     * @param item элемент
     */
    fun push(item: T) {
        stack?.push(item)
    }

    override fun run() {
        Thread.currentThread().name = "PushWorker"
        while (!Thread.currentThread().isInterrupted) {
            stack?.push(item)
            println("Поток " + Thread.currentThread().name + " вложил " + item)
        }
    }

}