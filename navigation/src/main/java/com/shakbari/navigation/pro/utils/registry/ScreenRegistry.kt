package com.shakbari.navigation.pro.utils.registry

import com.shakbari.navigation.pro.utils.screen.Screen
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

private typealias ProviderKey = KClass<out ScreenProvider>

private typealias ScreenFactory = (ScreenProvider) -> Screen

 object ScreenRegistry {

    @PublishedApi
    internal val factories: ConcurrentHashMap<ProviderKey, ScreenFactory> = ConcurrentHashMap()

     operator fun invoke(block: ScreenRegistry.() -> Unit) {
        this.block()
    }

     inline fun <reified T : ScreenProvider> register(noinline factory: (T) -> Screen) {
        factories[T::class] = factory as ScreenFactory
    }

     inline fun <reified T : ScreenProvider> get(provider: T): Screen {
        val factory = factories[T::class] ?: error("ScreenProvider not registered: ${T::class.qualifiedName}")
        return factory(provider)
    }
}
