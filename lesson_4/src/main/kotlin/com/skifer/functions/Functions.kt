package com.skifer.functions

import com.skifer.user.User
import com.skifer.user.UserUiModel

typealias Ui = UserUiModel

/**
 * Prints all information about User
 */
fun User.print(countOfSpaces: Int = 1, printerInside: (String) -> Unit) {
    printerInside ("Name:${" ".repeat(countOfSpaces)}$name\n" +
            "Last name:${" ".repeat(countOfSpaces)}$lastName\n" +
            "Job:${" ".repeat(countOfSpaces)}$job\n"
    )
}

/**
 * Converts User to UserUiModel
 * @return UserUiModel object
 */
fun User.toUi(): Ui {
    return UserUiModel(name, lastName)
}

/**
 * Prints all information about User
 */
inline fun User.printInline(countOfSpaces: Int = 1, printerInside: (String) -> Unit) {
    printerInside ("Name:${" ".repeat(countOfSpaces)}$name\n" +
            "Last name:${" ".repeat(countOfSpaces)}$lastName\n" +
            "Job:${" ".repeat(countOfSpaces)}$job\n"
    )
}
