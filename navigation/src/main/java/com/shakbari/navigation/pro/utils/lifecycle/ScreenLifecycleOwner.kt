package com.shakbari.navigation.pro.utils.lifecycle

import androidx.compose.runtime.Composable

interface ScreenLifecycleOwner {

    @Composable
    fun getHooks(): ScreenLifecycleHooks = ScreenLifecycleHooks.Empty
}

internal object DefaultScreenLifecycleOwner : ScreenLifecycleOwner
