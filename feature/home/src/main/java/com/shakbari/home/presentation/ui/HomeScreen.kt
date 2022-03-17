package com.shakbari.home.presentation.ui

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import com.shakbari.core.uikit.compose.AvatarImageWithCoil
import com.shakbari.core.uikit.compose.ErrorView
import com.shakbari.core.uikit.compose.LoadingView
import com.shakbari.home.domain.entity.User
import com.shakbari.home.presentation.intent.UsersIntent
import com.shakbari.home.presentation.state.UserState
import com.shakbari.home.presentation.viewmodel.UsersViewModel
import com.shakbari.navigation.Screen

@ExperimentalCoilApi
@Composable
internal fun HomeScreen(
    navController: NavController,
    usersViewModel: UsersViewModel
) {
    val context = LocalContext.current
    val users = usersViewModel.users.collectAsLazyPagingItems()

    when (val state = usersViewModel.state.collectAsState().value) {
        is UserState.Idle -> {
            LoadingView()
            usersViewModel.sendIntent(UsersIntent.GetUsers)
        }
        is UserState.Loading -> LoadingView()
        is UserState.Error,is UserState.Empty -> ErrorView()
        is UserState.Users ->{
                LoadHomeScreenView(
                    navController = navController,
                    users = users)
        }
    }



}

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
}

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
                navController.navigate(Screen.Detail.withArgs(user!!.name))
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
                Text(text = user!!.name)
                Spacer(modifier = Modifier.padding(6.dp))
                Text(text = user!!.email)
            }
        }
    }
}


