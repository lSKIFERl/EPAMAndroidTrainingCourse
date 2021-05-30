package com.skifer

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

fun main() {
    try {
        firstTask()
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}