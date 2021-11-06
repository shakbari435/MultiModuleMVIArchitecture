package com.shakbari.navigation.pro

import com.shakbari.navigation.pro.utils.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    object HomeScreen : SharedScreen()
    data class Details(val name: String) : SharedScreen()
}
