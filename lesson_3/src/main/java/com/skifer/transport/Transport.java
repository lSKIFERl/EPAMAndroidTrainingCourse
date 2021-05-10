package com.skifer.transport;

/**
 * Абстрактный класс траснпорта
 */
abstract public class Transport {

    /**
     * Цвет транспорта
     */
    protected String color;

    /**
     * Название транспорта
     */
    protected String name;

    /**
     * Колличество колёс
     */
    protected Integer wheels;

    /**
     * Возможная вместительность
     */
    protected Integer capacity;

    /**
     * Абстрактный класс траснпорта
     * @param color цвет
     * @param name название
     * @param wheels колличество колёс
     * @param capacity вместимость
     */
    public Transport(String color, String name, Integer wheels, Integer capacity) {
        this.color = color;
        this.name = name;
        this.wheels = wheels;
        this.capacity = capacity;
    }

    public abstract void getInfo();

    @Override
    public String toString() {
        return "{color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                ", capacity=" + capacity +
                '}';
    }
}