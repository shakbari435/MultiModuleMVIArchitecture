package com.shakbari.navigation.pro.internal

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.shakbari.navigation.pro.Navigator
import com.shakbari.navigation.pro.OnBackPressed

@Composable
internal fun NavigatorBackHandler(
    navigator: Navigator,
    onBackPressed: OnBackPressed
) {
    if (onBackPressed != null) {
        BackHandler(
            enabled = navigator.canPop || navigator.parent?.canPop ?: false,
            onBack = {
                if (onBackPressed(navigator.lastItem)) {
                    if (navigator.pop().not()) {
                        navigator.parent?.pop()
                    }
                }
            }
        )
    }
}
