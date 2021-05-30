package com.skifer;

import com.skifer.tasks.TaskFirst;

public class App {

    public static void main(String[] args) {
        TaskFirst taskFirst = new TaskFirst();
        try {
            taskFirst.firstTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
