package com.shakbari.navigation.pro.utils.screen

import androidx.compose.runtime.Composable
import java.io.Serializable

interface Screen : Serializable {

    val key: ScreenKey
        get() = this::class.qualifiedName
            ?: error("Default ScreenKey not found, please provide your own key")

    @Composable
    fun Content()
}
