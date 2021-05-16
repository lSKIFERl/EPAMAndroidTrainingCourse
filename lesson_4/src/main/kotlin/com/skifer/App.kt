package com.skifer

typealias Ui = UserUiModel

class App {

    fun User.print(countOfSpaces: Int) {
        val whiteSpace: String = " "
        println("Name: ${whiteSpace.repeat(countOfSpaces)}$name\n" +
                "Last name: ${whiteSpace.repeat(countOfSpaces)}$lastName\n" +
                "Job: ${whiteSpace.repeat(countOfSpaces)}$job")
    }

    fun User.toUi(): Ui {
        return UserUiModel(name, lastName)
    }


}
