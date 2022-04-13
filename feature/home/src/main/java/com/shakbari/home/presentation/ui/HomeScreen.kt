package com.shakbari.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.shakbari.core.uikit.compose.AvatarImageWithCoil
import com.shakbari.core.uikit.compose.ErrorView
import com.shakbari.core.uikit.compose.LoadingView
import com.shakbari.home.domain.entity.User
import com.shakbari.home.presentation.contract.HomeContract
import com.shakbari.home.presentation.viewmodel.UsersViewModel
import com.shakbari.navigation.Screen

@ExperimentalCoilApi
@Composable

internal fun HomeScreen(
    navController: NavController,
    usersViewModel: UsersViewModel,
) {

    when (val screenState = usersViewModel.uiState.collectAsState().value) {
        is HomeContract.ScreenState.Idle -> {
            usersViewModel.setIntent(
                intent = HomeContract.Intent.GetUsers
            )
        }
        is HomeContract.ScreenState.Loading -> LoadingView()
        is HomeContract.ScreenState.SideEffect -> {
            SideEffectHandler(
                effectState = screenState.sideEffect
            )
        }
        is HomeContract.ScreenState.Users -> {
            UsersStateHandler(
                userState = screenState.userState,
                navController = navController,
                usersViewModel
            )
        }
    }

}

@Composable
fun SideEffectHandler(effectState: HomeContract.SideEffect) {
    when (effectState) {
        is HomeContract.SideEffect.ShowError -> {
            ErrorView()
        }
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun UsersStateHandler(userState: HomeContract.UsersState, navController: NavController,usersViewModel: UsersViewModel) {
    when (userState) {
        is HomeContract.UsersState.Loading -> LoadingView()
        is HomeContract.UsersState.Error,
        is HomeContract.UsersState.Empty -> ErrorView()
        is HomeContract.UsersState.Success -> {
            val users = userState.users.collectAsState()
            LoadHomeScreenView2(
                navController = navController,
                users = users.value,
                usersViewModel = usersViewModel
            )
        }
/*        is HomeContract.UsersState.SuccessPaging -> {
            val users = userState.users.collectAsLazyPagingItems()
            LoadHomeScreenView(
                navController = navController,
                users = users
            )
        }*/
    }
}
/*
@ExperimentalCoilApi
@Composable
fun LoadHomeScreenView(navController: NavController, users: LazyPagingItems<User>) {
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
        LazyColumn(modifier = Modifier.background(Color.DarkGray)) {
            items(users) { user ->
                UserCardView(navController = navController, user = user!!)
            }

            users.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item { LoadingView() }
                    }
                    loadState.append is LoadState.Loading -> {
                        item { LoadingView() }
                    }
                    loadState.refresh is LoadState.Error -> {

                    }
                    loadState.append is LoadState.Error -> {

                    }
                }
            }
        }
    }
}*/


@ExperimentalCoilApi
@Composable
fun LoadHomeScreenView2(
    navController: NavController,
    users: MutableList<User>,
    usersViewModel: UsersViewModel
) {
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
        LazyColumn(modifier = Modifier.background(Color.DarkGray)) {
            val threshold = 3
            val lastIndex = users.lastIndex
            itemsIndexed(users) { index ,user ->
                UserCardView(navController = navController, user = user)
                if (index + threshold >= lastIndex && !usersViewModel.isLoadMoreLoading.value) {
                    SideEffect {
                        usersViewModel.setIntent(HomeContract.Intent.GetUsers)
                    }
                }
            }
            if(usersViewModel.isLoadMoreLoading.value){
                item { LoadingView() }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserCardView(
    navController: NavController,
    user: User,
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screen.Detail.withArgs(user.name))
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


