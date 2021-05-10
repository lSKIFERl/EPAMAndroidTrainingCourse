package com.skifer.teacher;

import java.util.Objects;

/**
 * Простой класс учителя
 */
public class Teacher {

    /**
     * Имя
     */
    private String firstName;

    /**
     * Фамилия
     */
    private String lastName;

    /**
     * Возраст
     */
    private Integer age;

    /**
     * Курируемый класс
     */
    private String supervisedClass;

    /**
     * Опыт работы
     */
    private Integer experience;

    /**
     * Простой класс учителя
     * @param firstName Имя
     * @param lastName фамилия
     * @param age возраст
     * @param supervisedClass курируемый класс
     * @param experience опыт
     */
    public Teacher(String firstName, String lastName, Integer age, String supervisedClass, Integer experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.supervisedClass = supervisedClass;
        this.experience = experience;
    }

    /**
     * Простой класс учителя
     * @param firstName Имя
     * @param lastName фамилия
     * @param age возраст
     */
    public Teacher(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.experience = 0;
        this.supervisedClass = "None";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSupervisedClass() {
        return supervisedClass;
    }

    public void setSupervisedClass(String supervisedClass) {
        this.supervisedClass = supervisedClass;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "com.skifer.Teacher.com.skifer.Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", supervisedClass='" + supervisedClass + '\'' +
                ", experience=" + experience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(firstName, teacher.firstName) &&
                Objects.equals(lastName, teacher.lastName) &&
                Objects.equals(age, teacher.age) &&
                Objects.equals(supervisedClass, teacher.supervisedClass) &&
                Objects.equals(experience, teacher.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, supervisedClass, experience);
    }
}
