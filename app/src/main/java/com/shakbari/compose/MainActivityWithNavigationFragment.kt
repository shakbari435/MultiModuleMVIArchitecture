package com.shakbari.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.shakbari.navigation.fragmentnavigation.BaseNavigation
import com.shakbari.navigation.fragmentnavigation.NavFragment
import com.shakbari.navigation.fragmentnavigation.NavigatorFragment

class MainActivityWithNavigationFragment : AppCompatActivity(), BaseNavigation {
    private val navControllers by lazy {
        findNavController(R.id.nav_host_fragment)
    }
    private val navigator: NavigatorFragment by lazy {
        NavigatorFragment().apply {
            this@apply.navController = navControllers
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* val navView: BottomNavigationView = findViewById(R.id.nav_view)
         navView.setupWithNavController(navControllers)*/
    }

    override fun onBackPressed() {
        if (navControllers.popBackStack().not()) {
            finish()
        }
    }

        override fun pushFragment(navFragment: NavFragment) {
        navigator.pushFragment(navFragment)
    }

    override fun popFragment() {
        navigator.popFragment()
    }

    override fun popAllFragment() {
        navigator.popAllFragment()
    }
}