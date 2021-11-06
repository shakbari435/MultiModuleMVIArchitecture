package com.shakbari.navigation.pro.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.shakbari.navigation.pro.Navigator
import com.shakbari.navigation.pro.utils.lifecycle.ScreenLifecycleStore
import com.shakbari.navigation.pro.utils.model.ScreenModelStore
import com.shakbari.navigation.pro.utils.stack.StackEvent

private val disposableEvents: Set<StackEvent> =
    setOf(StackEvent.Pop, StackEvent.Replace)

@Composable
internal fun NavigatorDisposableEffect(
    navigator: Navigator,
    onDispose: () -> Unit
) {
    val currentScreen = navigator.lastItem

    DisposableEffect(currentScreen.key) {
        onDispose {
            if (navigator.lastEvent in disposableEvents) {
                onDispose()
                ScreenModelStore.remove(currentScreen)
                ScreenLifecycleStore.remove(currentScreen)
                navigator.stateHolder.removeState(currentScreen.key)
                navigator.clearEvent()
            }
        }
    }
}
