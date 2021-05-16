package com.skifer.teacher

class TeacherKt (
    var name:String,
    var lastName:String,
    var age:Int,
    var supervisedClass:String,
    var experience:Int
) {
    constructor(name: String, lastName: String, age: Int): this(name, lastName, age, "None", 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TeacherKt) return false

        if (name != other.name) return false
        if (lastName != other.lastName) return false
        if (age != other.age) return false
        if (supervisedClass != other.supervisedClass) return false
        if (experience != other.experience) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + age
        result = 31 * result + supervisedClass.hashCode()
        result = 31 * result + experience
        return result
    }
}