package com.shakbari.navigation.pro.utils.lifecycle

import androidx.compose.runtime.ProvidedValue

data class ScreenLifecycleHooks(
    val providers: List<ProvidedValue<*>> = emptyList(),
    val onDispose: () -> Unit = {}
) {

    internal companion object {
        val Empty = ScreenLifecycleHooks()
    }
}
