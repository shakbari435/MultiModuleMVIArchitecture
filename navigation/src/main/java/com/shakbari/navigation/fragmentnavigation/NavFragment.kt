package com.shakbari.navigation.fragmentnavigation

sealed class NavFragment {
    object Home : NavFragment()
    class Details(val msg: String) : NavFragment()
}