package com.skifer.transport.realisations;

import com.skifer.transport.Transport;

public class Bus extends Transport {

    /**
     * Является ли автобус двухэтажным
     */
    protected Boolean doubleFloored;

    /**
     * Класс автобуса
     *
     * @param color    цвет
     * @param name     название
     * @param wheels   колличество колёс
     * @param capacity вместимость
     * @param doubleFloored является ли автобус двухэтажным
     */
    public Bus(String color, String name, Integer wheels, Integer capacity, Boolean doubleFloored) {
        super(color, name, wheels, capacity);
        this.doubleFloored = doubleFloored;
    }

    @Override
    public String toString() {
        return "{" +
                "doubleFloored=" + doubleFloored +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public void getInfo() {
        System.out.println(this);
        if (this.doubleFloored)
            System.out.println("Божечки, да это ж великлопено!");
    }
}
