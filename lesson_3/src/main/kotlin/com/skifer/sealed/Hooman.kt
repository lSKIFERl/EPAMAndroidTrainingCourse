package com.skifer.sealed

import com.skifer.enums.MarriedKt

sealed class Hooman {
    class Student(val age: Int, val name: String, val points: Int, val studyField: String, val married: MarriedKt): Hooman()
    class Teacher(val name: String, val experience: Int, val age: Int): Hooman()
    class Rector(val name: String, val experience: Int, val university: String, val married: MarriedKt): Hooman()
}