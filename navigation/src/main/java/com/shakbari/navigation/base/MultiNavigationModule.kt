package com.shakbari.navigation.base

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

internal const val APP_GRAPH_NAME = "MultiNavigationGraph.AppNavGraph"

fun multiNavigationModule(
    vararg ncModules: NavComposableModule,
    graphName: () -> String = { APP_GRAPH_NAME }
) {
    require(ncModules.isNotEmpty()) { "At least one NavComposeModule is required." }
    MultiNavCompose.navComposableModules[graphName()] = ncModules.toList()
}

fun interface NavComposableModule {
    fun createNavComposable(navHost: NavGraphBuilder, navController: NavHostController)
}
