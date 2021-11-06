package com.shakbari.navigation.base

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.loadMultiNavComposable(
    navController: NavHostController,
    graphName: String = APP_GRAPH_NAME,
    navComposableModules: List<NavComposableModule>? = null
) {
    (navComposableModules ?: getNavComposableModulesFromGraph(graphName))
        .forEach { module ->
            module.createNavComposable(this, navController)
        }
}

fun getNavComposableModulesFromGraph(graphName: String): List<NavComposableModule> {
    return checkNotNull(MultiNavCompose.navComposableModules[graphName]) {
        "NavComposableModules not found for $graphName. Did you called multiNavModules before?"
    }
}

internal object MultiNavCompose {
    val navComposableModules = mutableMapOf<String, List<NavComposableModule>>()
}
