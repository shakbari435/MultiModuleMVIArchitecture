package com.shakbari.navigation.fragmentnavigation

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    fun pushFragment(navFragment: NavFragment) {
        (requireActivity() as BaseNavigation).pushFragment(navFragment)
    }

    fun popFragment() {
        (requireActivity() as BaseNavigation).popFragment()
    }

    fun popAllFragment() {
        (requireActivity() as BaseNavigation).popAllFragment()
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}