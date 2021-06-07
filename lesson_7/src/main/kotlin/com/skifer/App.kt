package com.skifer

import com.skifer.secondtask.PopWorker
import com.skifer.secondtask.PushWorker
import com.skifer.secondtask.Stack
import com.skifer.secondtask.StackFactory
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import kotlin.random.Random

@Volatile var stack: Stack<Int?>? = null

/**
 * Метод, вызывающий 2 потока на 10 секунд с инетрвалом в 5 секунд между вызовами
 */
fun firstTask() {
    val thread2: Thread = object : Thread("Thread 2") {
        override fun run() {
            println(name)
        }
    }
    val thread1: Thread = object : Thread("Thread 1") {
        override fun run() {
            println(name)
            Thread.sleep(5000)
            thread2.start()
            thread2.join()
        }
    }
    thread1.start()
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

fun thirdTask() {
    var executor = Executors.newSingleThreadExecutor()
    for (i in 0..2) {
        executor.execute(Runnable {
            run { println("[1] Исполняется " + Thread.currentThread().name) }
        })
    }
    executor.shutdown()

    executor = Executors.newFixedThreadPool(3)
    val invocationList = mutableListOf<Callable<String>>()
    for (i in 0..4) {
        invocationList.add(Callable { "[2] Исполняется " + Thread.currentThread().name })
    }
    val futureList: List<Future<String>> = executor.invokeAll(invocationList)
    for (future in futureList) println(future.get())
    executor.shutdown()

    executor = Executors.newCachedThreadPool()
    for (i in 0..2) {
        executor.execute(Runnable {
            run { println("[3] Исполняется " + Thread.currentThread().name) }
        })
    }
    executor.shutdown()

    val executorScheduled = Executors.newScheduledThreadPool(2)
    for (i in 0..2) {
        executorScheduled.schedule (Runnable {
            run { println("[4] Исполняется " + Thread.currentThread().name) }
        },0, TimeUnit.NANOSECONDS)
        Thread.sleep(3000)
    }
    executorScheduled.shutdown()
}

fun main() {
    try {
        firstTask()
        //secondTask()
        //thirdTask()
    } catch (e: InterruptedException) {
        //e.printStackTrace()
    }
}