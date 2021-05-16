package com.skifer

class App {
    fun User.print(job: String = "Unemployed") {
        println("Name: $name\nLast name: $lastName\nJoba: $job")
    }
}