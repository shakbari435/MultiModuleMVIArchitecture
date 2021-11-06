package com.shakbari.navigation

sealed class Screen(val name: String) {
    object Home : Screen("home_screen")
    object Detail : Screen("details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(name)
            args.forEach { args ->
                append("/$args")
            }
        }
    }
}