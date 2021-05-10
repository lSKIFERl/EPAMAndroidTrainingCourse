package com.skifer;

import com.skifer.teacher.Teacher;
import com.skifer.transport.realisations.Car;

public class App {

    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Константин", "Костенко", 256789);
        Teacher teacher2 = new Teacher("Константин", "Костенко", 256789);
        System.out.println(teacher1.equals(teacher2));
        teacher1.setExperience(256777);
        System.out.println(teacher1.equals(teacher2));
        Car car = new Car("Purple", "Haze" );
        System.out.println(car);
    }
}
