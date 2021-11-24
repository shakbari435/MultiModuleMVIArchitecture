package com.shakbari.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.shakbari.navigation.fragmentnavigation.BaseFragment
import com.shakbari.navigation.fragmentnavigation.NavFragment


class HomeFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Button(
                    onClick = { pushFragment(NavFragment.Details("Android")) }
                ) {
                    Text(text = "Hello")
                }
            }
        }
    }

/*    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        to_next_fragment_btn.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNextFragment())
        }

        to_dashboard_flow.setOnClickListener {
            pushFragment(NavFragment.DashboardFlow("From home fragment"))
        }
    }*/
}