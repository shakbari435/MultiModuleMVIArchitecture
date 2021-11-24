package com.shakbari.navigation.fragmentnavigation

interface BaseNavigation {
    fun pushFragment(navFragment: NavFragment)
    fun popFragment()
    fun popAllFragment()
}