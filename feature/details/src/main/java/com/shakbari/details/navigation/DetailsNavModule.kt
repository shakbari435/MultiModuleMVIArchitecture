package com.shakbari.details.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.shakbari.details.DetailScreen
import com.shakbari.navigation.Screen
import com.shakbari.navigation.base.NavComposableModule

val detailScreenNavModule = NavComposableModule { navHost, navController ->
    navHost.apply {
        composable(
            route = Screen.Detail.name + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "name"
                    nullable = false
                }
            )
        ) { entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name"),
            )
        }

    }

}