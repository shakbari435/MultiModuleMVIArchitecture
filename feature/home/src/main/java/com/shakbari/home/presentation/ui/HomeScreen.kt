package com.shakbari.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.shakbari.core.base.ViewState
import com.shakbari.core.uikit.compose.AvatarImageWithCoil
import com.shakbari.core.uikit.compose.ErrorView
import com.shakbari.core.uikit.compose.LoadingView
import com.shakbari.home.domain.entity.User
import com.shakbari.home.presentation.state.UserListState
import com.shakbari.home.presentation.viewmodel.UsersViewModel
import com.shakbari.navigation.Screen
import kotlinx.coroutines.flow.collectLatest

@ExperimentalCoilApi
@Composable
internal fun HomeScreen(
    navController: NavController,
    usersViewModel: UsersViewModel
) {
   // val state = usersViewModel.userState.value


    val state = usersViewModel.userState3
        .collectAsState(initial = UserListState(isLoading = true)).value



    if (state.isLoading) {
        LoadingView()
    } else if (state.users.isNotEmpty()) {
        LoadHomeScreenView(navController = navController, users = state.users as ArrayList<User>)
    } else if (state.isError || state.isEmpty) {
        ErrorView()
    }


}

@ExperimentalCoilApi
@Composable
fun LoadHomeScreenView(navController: NavController, users: ArrayList<User>) {
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
        }
    }
}



