package com.skifer

import com.skifer.secondtask.PopWorker
import com.skifer.secondtask.PushWorker
import com.skifer.secondtask.Stack
import com.skifer.secondtask.StackFactory
import java.util.concurrent.*
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

    val task =
        object : Callable<Stack<Int?>?> {
            private var stack: Stack<Int?>? = StackFactory.create()

            override fun call(): Stack<Int?>? {
                return stack
            }
        }

    val future: FutureTask<Stack<Int?>?> = FutureTask(task)
    val threading = Thread(future)
    threading.start()
    threading.join()
    println("Поток " + Thread.currentThread().name + " сделал и достал стек")

    stack = future.get()
    println("Поток " + Thread.currentThread().name + " вытащил стек")
    //
    val thread1 = Thread(PushWorker(stack, Random.nextInt(0, 100)))
    val thread2 = Thread(PopWorker(stack))

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
        executor.execute {
            println("[1] Исполняется " + Thread.currentThread().name)
        }
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
        executor.execute {
            println("[3] Исполняется " + Thread.currentThread().name)
        }
    }
    executor.shutdown()

    val executorScheduled = Executors.newScheduledThreadPool(2)
    for (i in 0..2) {
        executorScheduled.schedule ({
            run { println("[4] Исполняется " + Thread.currentThread().name) }
        },3, TimeUnit.SECONDS)
    }
    executorScheduled.shutdown()
}