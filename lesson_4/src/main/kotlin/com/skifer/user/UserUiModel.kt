package com.skifer.user

/**
 * Simple UserUiModel class
 */
class UserUiModel(private val name: String, private val lastName: String) {
    override fun toString(): String {
        return "UserUiModel(name='$name', lastName='$lastName')"
    }
}