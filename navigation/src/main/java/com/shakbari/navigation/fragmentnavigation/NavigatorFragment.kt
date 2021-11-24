package com.shakbari.navigation.fragmentnavigation

import androidx.navigation.NavController
import com.shakbari.navigation.MainNavGraphDirections
import com.shakbari.navigation.R
import com.shakbari.navigation.fragmentnavigation.NavFragment

class NavigatorFragment {
    var navController: NavController? = null

    // navigate on main thread or nav component crashes sometimes
    fun pushFragment(navigationFlow: NavFragment) = when (navigationFlow) {
        is NavFragment.Home -> {
            navController?.navigate(MainNavGraphDirections.actionGlobalHome())
        }
        is NavFragment.Details -> {
            navController?.navigate(
                MainNavGraphDirections.actionGlobalDetails(
                    navigationFlow.msg
                )
            )
        }
        else -> {}
    }

    fun popFragment() {
        navController?.popBackStack()
    }

    fun popAllFragment() {
        navController?.popBackStack(R.id.home_navigation, true)
    }
}