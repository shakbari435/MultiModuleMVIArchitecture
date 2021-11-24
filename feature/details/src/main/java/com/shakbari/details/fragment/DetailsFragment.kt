package com.shakbari.details.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.shakbari.navigation.fragmentnavigation.BaseFragment


class DetailsFragment : BaseFragment() {
    private val detailsFragmentArgs: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Text(text = "Hello ً${detailsFragmentArgs.msg}")
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