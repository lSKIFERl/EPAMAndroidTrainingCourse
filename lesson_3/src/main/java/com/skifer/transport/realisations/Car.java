package com.skifer.transport.realisations;

import com.skifer.transport.Transport;

public class Car extends Transport {

    /**
     * Класс машины
     *
     * @param color    цвет
     * @param name     название
     * @param wheels   колличество колёс
     * @param capacity вместимость
     */
    public Car(String color, String name, Integer wheels, Integer capacity) {
        super(color, name, wheels, capacity);
    }

    public Car(String color, String name) {
        super(color, name, 4, 5);
    }

    @Override
    public void getInfo() {
        System.out.println("Аааааавтомобиль! \n" + this);
    }
}
