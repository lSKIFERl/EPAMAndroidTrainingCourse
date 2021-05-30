package com.skifer.tasks;

public class TaskFirst {
    public void firstTask() throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                setName("Thread 1");
                for(int i = 0; i < 10; i++) {
                    System.out.println(getName());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                setName("Thread 2");
                for(int i = 0; i < 10; i++) {
                    System.out.println(getName());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
        Thread.sleep(5000);
        thread2.start();
        thread2.join();

        if(!(thread1.isAlive() && thread2.isAlive())) {
            System.out.println(Thread.currentThread().getName() + " is ready");
        }
    }
}
