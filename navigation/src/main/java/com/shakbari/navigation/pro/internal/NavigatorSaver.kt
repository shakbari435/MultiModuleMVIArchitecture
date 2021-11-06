package com.shakbari.navigation.pro.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.staticCompositionLocalOf
import com.shakbari.navigation.pro.Navigator
import com.shakbari.navigation.pro.utils.screen.Screen

internal val LocalNavigatorStateHolder: ProvidableCompositionLocal<SaveableStateHolder> =
    staticCompositionLocalOf { error("LocalNavigatorStateHolder not initialized") }

@Composable
internal fun rememberNavigator(
    screens: List<Screen>,
    parent: Navigator?
): Navigator {
    val stateHolder = LocalNavigatorStateHolder.current

    return rememberSaveable(saver = navigatorSaver(stateHolder, parent)) {
        Navigator(screens, stateHolder, parent)
    }
}

private fun navigatorSaver(
    stateHolder: SaveableStateHolder,
    parent: Navigator?
): Saver<Navigator, Any> =
    listSaver(
        save = { navigator -> navigator.items },
        restore = { items -> Navigator(items, stateHolder, parent) }
    )
