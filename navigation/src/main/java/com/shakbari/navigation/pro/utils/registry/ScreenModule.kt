package com.shakbari.navigation.pro.utils.registry

private typealias ScreenModule = ScreenRegistry.() -> Unit

 fun screenModule(block: ScreenModule): ScreenModule =
    { block() }
