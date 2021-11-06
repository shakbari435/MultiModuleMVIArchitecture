package com.shakbari.navigation.pro

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.staticCompositionLocalOf
import com.shakbari.navigation.pro.internal.NavigatorBackHandler
import com.shakbari.navigation.pro.internal.NavigatorDisposableEffect
import com.shakbari.navigation.pro.internal.LocalNavigatorStateHolder
import com.shakbari.navigation.pro.internal.rememberNavigator
import com.shakbari.navigation.pro.utils.lifecycle.rememberScreenLifecycleOwner
import com.shakbari.navigation.pro.utils.screen.Screen
import com.shakbari.navigation.pro.utils.stack.Stack
import com.shakbari.navigation.pro.utils.stack.toMutableStateStack

typealias NavigatorContent = @Composable (navigator: Navigator) -> Unit

typealias OnBackPressed = ((currentScreen: Screen) -> Boolean)?

val navController: ProvidableCompositionLocal<Navigator?> =
    staticCompositionLocalOf { null }

val <T> ProvidableCompositionLocal<T?>.currentScreen: T
    @Composable
    get() = current ?: error("CompositionLocal is null")


@Composable
fun CurrentScreen() {
    val navigator = navController.currentScreen
    val currentScreen = navigator.lastItem

    navigator.stateHolder.SaveableStateProvider(currentScreen.key) {
        currentScreen.Content()
    }
}

@Composable
fun Navigator(
    screen: Screen,
    autoDispose: Boolean = true,
    onBackPressed: OnBackPressed = { true },
    content: NavigatorContent = { CurrentScreen() }
) {
    Navigator(
        screens = listOf(screen),
        autoDispose = autoDispose,
        onBackPressed = onBackPressed,
        content = content
    )
}

@Composable
fun Navigator(
    screens: List<Screen>,
    autoDispose: Boolean = true,
    onBackPressed: OnBackPressed = { true },
    content: NavigatorContent = { CurrentScreen() }
) {
    require(screens.isNotEmpty()) { "Navigator must have at least one screen" }

    CompositionLocalProvider(
        LocalNavigatorStateHolder providesDefault rememberSaveableStateHolder()
    ) {
        val navigator = rememberNavigator(screens, navController.current)
        val lifecycleOwner = rememberScreenLifecycleOwner(navigator.lastItem)
        val hooks = lifecycleOwner.getHooks()

        CompositionLocalProvider(
            navController provides navigator,
            *hooks.providers.toTypedArray()
        ) {
            if (autoDispose) NavigatorDisposableEffect(navigator, hooks.onDispose)

            NavigatorBackHandler(navigator, onBackPressed)

            content(navigator)
        }
    }
}

class Navigator internal constructor(
    screens: List<Screen>,
    val stateHolder: SaveableStateHolder,
    val parent: Navigator? = null
) : Stack<Screen> by screens.toMutableStateStack(minSize = 1) {

    val level: Int =
        parent?.level?.inc() ?: 0

    val lastItem: Screen by derivedStateOf {
        lastItemOrNull ?: error("Navigator has no screen")
    }

    @Deprecated(
        message = "Use 'lastItem' instead. Will be removed in 1.0.0.",
        replaceWith = ReplaceWith("lastItem")
    )
    val last: Screen by derivedStateOf {
        lastItem
    }

    fun popUntilRoot() {
        popUntilRoot(this)
    }

    private tailrec fun popUntilRoot(navigator: Navigator): Navigator {
        navigator.popAll()

        return if (navigator.parent == null) {
            navigator
        } else {
            popUntilRoot(navigator.parent)
        }
    }
}
