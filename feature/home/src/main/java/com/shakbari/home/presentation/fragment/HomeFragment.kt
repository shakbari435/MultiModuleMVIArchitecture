package com.shakbari.home.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.shakbari.home.presentation.viewmodel.UsersViewModel
import com.shakbari.navigation.fragmentnavigation.BaseFragment
import com.shakbari.navigation.fragmentnavigation.NavFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private val usersViewModel : UsersViewModel by viewModels()
    @ExperimentalCoilApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                HomeScreenWitNavFragment(
                    baseNavigation = baseNavigation,
                    usersViewModel = usersViewModel
                )
            }
        }
    }

}