package com.shakbari.navigation.pro.utils.registry

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.shakbari.navigation.pro.utils.screen.Screen

@Composable
 inline fun <reified T : ScreenProvider> rememberScreen(provider: T): Screen =
    remember(provider) {
        ScreenRegistry.get(provider)
    }

 interface ScreenProvider
