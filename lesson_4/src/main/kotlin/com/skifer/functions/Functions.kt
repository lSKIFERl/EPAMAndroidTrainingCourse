package com.skifer.functions

import com.skifer.user.User
import com.skifer.user.UserUiModel

typealias UiModel = UserUiModel

/**
 * Prints all information about User
 */
fun User.print(countOfSpaces: Int = 1, printerInside: (String) -> Unit) {
    val whiteSpace = " ".repeat(countOfSpaces)
    printerInside ("Name:$whiteSpace$name\n" +
            "Last name:$whiteSpace$lastName\n" +
            "Job:$whiteSpace$job\n"
    )
}

/**
 * Converts User to UserUiModel
 * @return UserUiModel object
 */
fun User.toUi(): UiModel {
    return UserUiModel(name, lastName)
}

/**
 * Prints all information about User
 */
inline fun User.printInline(countOfSpaces: Int = 1, printerInside: (String) -> Unit) {
    val whiteSpace = " ".repeat(countOfSpaces)
    printerInside ("Name:$whiteSpace$name\n" +
            "Last name:$whiteSpace$lastName\n" +
            "Job:$whiteSpace$job\n"
    )
}
