package com.skifer

import com.skifer.functions.print
import com.skifer.functions.printInline
import com.skifer.functions.toUi
import com.skifer.user.User

fun main() {
    var standUser: User = User(
        name = "Jotaro",
        lastName = "Kudjo"
    )
    standUser.print (5) { print(it) }

    standUser.job = "Traveller"
    standUser.printInline { standUser.print(2) { print(it)} } //¯\_(ツ)_/¯

    print(standUser.toUi())
}