package com.shakbari.home.presentation.fragment

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.shakbari.core.base.UiState
import com.shakbari.core.base.ViewState
import com.shakbari.core.uikit.compose.AvatarImageWithCoil
import com.shakbari.core.uikit.compose.ErrorView
import com.shakbari.core.uikit.compose.LoadingView
import com.shakbari.home.domain.entity.User
import com.shakbari.home.presentation.viewmodel.UsersViewModel
import com.shakbari.navigation.Screen
import com.shakbari.navigation.fragmentnavigation.BaseNavigation
import com.shakbari.navigation.fragmentnavigation.NavFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@ExperimentalCoilApi
@Composable

internal fun HomeScreenWitNavFragment(
    baseNavigation: BaseNavigation,
    usersViewModel: UsersViewModel
) {
/*    val user = usersViewModel.uiState.collectAsState()
    user.value.apply {
        when(this){
            is UiState.Loading ->{}
            is UiState.Success ->
        }
    }*/
    val viewState by remember(usersViewModel) { usersViewModel.getUsers() }
        .collectAsState(initial = ViewState.Loading)

    val viewState2 by remember(usersViewModel) { usersViewModel.getUsers2() }
        .collectAsState(initial = UiState.Loading)


    viewState2.apply {
            when (this) {
                is UiState.Loading -> LoadingView()
                is UiState.Success<*> -> LoadHomeScreenView(baseNavigation, data as ArrayList<User>)
                is UiState.Empty, is UiState.Error -> ErrorView()
            }
        }
}

@ExperimentalCoilApi
@Composable
fun LoadHomeScreenView(baseNavigation: BaseNavigation, users: ArrayList<User>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(text = "Created by")
                        Text(text = " s.h.akbari435@gmail")
                    }
                }
            )
        },
    ) {
        LazyColumn(modifier = Modifier.background(Color.DarkGray)){
            items(users) { user ->
                Card(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable {
                            baseNavigation.pushFragment(NavFragment.Details(user.name))
                        },
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AvatarImageWithCoil(
                            url = "https://statics.basalam.com/public/users/BkKX/2108/5ZCxnmum2qvnKFThJxvcEftMiFwTtTbmgxCVwK0l.jpg_100X100X90.jpg"
                        )
                        Column(
                            modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = user.name)
                            Spacer(modifier = Modifier.padding(6.dp))
                            Text(text = user.email)
                        }
                    }
                }
            }
        }
    }
}

val LocalBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcher> { error("No Back Dispatcher provided") }

@Composable
fun BackPressHandler(onBackPressed: () -> Unit) {
    // Safely update the current `onBack` lambda when a new one is provided
    val currentOnBackPressed by rememberUpdatedState(onBackPressed)

    // Remember in Composition a back callback that calls the `onBackPressed` lambda
    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    val backDispatcher = LocalBackPressedDispatcher.current

    // Whenever there's a new dispatcher set up the callback
    DisposableEffect(backDispatcher) {
        backDispatcher.addCallback(backCallback)
        // When the effect leaves the Composition, or there's a new dispatcher, remove the callback
        onDispose {
            backCallback.remove()
        }
    }
}



