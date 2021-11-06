package com.shakbari.navigation.pro.utils.screen

import java.util.concurrent.atomic.AtomicInteger

 typealias ScreenKey = String

private val nextScreenKey = AtomicInteger(0)

 val Screen.uniqueScreenKey: ScreenKey
    get() = "Screen#${nextScreenKey.getAndIncrement()}"
