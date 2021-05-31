package com.skifer

import com.skifer.secondtask.PopWorker
import com.skifer.secondtask.PushWorker
import com.skifer.secondtask.Stack
import com.skifer.secondtask.StackFactory
import java.util.concurrent.Callable
import kotlin.random.Random

@Volatile var stack: Stack<Int?>? = null

/**
 * Метод, вызывающий 2 потока на 10 секунд с инетрвалом в 5 секунд между вызовами
 */
fun firstTask() {
    val thread1: Thread = object : Thread() {
        override fun run() {
            name = "Thread 1"
            for (i in 0..9) {
                println(name)
                try {
                    sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
    val thread2: Thread = object : Thread() {
        override fun run() {
            name = "Thread 2"
            for (i in 0..9) {
                println(name)
                try {
                    sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
    thread1.start()
    Thread.sleep(5000)
    thread2.start()
    thread2.join()
    if (!(thread1.isAlive && thread2.isAlive)) {
        println(Thread.currentThread().name + " is ready")
    }
}

fun secondTask() {

    val thread =
        object : Callable<Stack<Int?>?>, Runnable {
            private var stack: Stack<Int?>? = null

            override fun call(): Stack<Int?>? {
                return stack
            }

            override fun run() {
                Thread.currentThread().name = "1"
                val stackFactory = StackFactory<Int?>()
                stackFactory.createStack()
                stack = stackFactory.stack
                println("Поток " + Thread.currentThread().name + " сделал и достал стек")
            }
        }
    val threading = Thread(thread)
    threading.start()
    threading.join()

    stack = thread.call()
    println("Поток " + Thread.currentThread().name + " вытащил стек")
    //
    val thread1 = Thread(object: Runnable {
        val pushWorker = PushWorker(stack)
        override fun run() {
            Thread.currentThread().name = "2"
            while (!Thread.currentThread().isInterrupted) {
                val random = Random.nextInt(0, 100)
                pushWorker.push(random)
                println("Поток " + Thread.currentThread().name + " вложил " + random)
            }
        }
    })
    val thread2 = Thread(object: Runnable {
        val popWorker = PopWorker(stack)
        override fun run() {
            Thread.currentThread().name = "3"
            while (!Thread.currentThread().isInterrupted) {
                println("Поток " + Thread.currentThread().name + " Вытащил " + popWorker.pop())
            }
        }
    })

    thread1.start()
    thread2.start()

    Thread.sleep(3000)
    thread1.interrupt()
    if(thread1.isInterrupted) {
        println(thread1.name + " прерван")
    }
    thread2.interrupt()
    if(thread2.isInterrupted) {
        println(thread2.name + " прерван")
    }
}

fun main() {
    try {
        //firstTask()
        secondTask()
    } catch (e: InterruptedException) {
        //e.printStackTrace()
    }
}