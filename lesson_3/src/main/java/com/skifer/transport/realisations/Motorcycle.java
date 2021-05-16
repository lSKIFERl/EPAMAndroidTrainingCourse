package com.skifer.transport.realisations;

import com.skifer.transport.Transport;

public class Motorcycle extends Transport{

    /**
     * Тип мотоцикла
     */
    protected String type;

    /**
     * Класс мотоцикла
     *
     * @param color    цвет
     * @param name     название
     * @param wheels   колличество колёс
     * @param capacity вместимость
     * @param type     тип мотоцикла
     */
    public Motorcycle(String color, String name, Integer wheels, Integer capacity, String type) {
        super(color, name, wheels, capacity);
        this.type = type;
    }

    public Motorcycle(String name) {
        super("Black", name, 2, 1);
        this.type = "Скутер"; //¯\_(ツ)_/¯
    }

    @Override
    public void printInfo() {
        System.out.println("Быстро, шумно, круто \n" + this);
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                ", capacity=" + capacity +
                '}';
    }
}
