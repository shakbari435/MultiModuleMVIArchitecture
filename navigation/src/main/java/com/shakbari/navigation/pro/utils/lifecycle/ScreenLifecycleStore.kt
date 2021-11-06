package com.shakbari.navigation.pro.utils.lifecycle

import com.shakbari.navigation.pro.utils.screen.Screen
import com.shakbari.navigation.pro.utils.screen.ScreenKey
import java.util.concurrent.ConcurrentHashMap

object ScreenLifecycleStore {

    private val owners = ConcurrentHashMap<ScreenKey, ScreenLifecycleOwner>()

    fun get(
        screen: Screen,
        factory: (ScreenKey) -> ScreenLifecycleOwner
    ): ScreenLifecycleOwner =
        owners.getOrPut(screen.key) { factory(screen.key) }

    fun remove(screen: Screen) {
        owners -= screen.key
    }
}
