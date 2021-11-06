package com.shakbari.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.shakbari.compose.ui.theme.ComposeBaseTheme
import com.shakbari.navigation.Screen
import com.shakbari.navigation.base.loadMultiNavComposable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            ComposeBaseTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.name
                ) {
                    loadMultiNavComposable(navController)
                }

            }
        }
    }
}

