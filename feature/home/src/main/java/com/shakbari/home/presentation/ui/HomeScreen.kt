package com.shakbari.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
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
import coil.annotation.ExperimentalCoilApi
import com.shakbari.core.uikit.compose.AvatarImageWithCoil
import com.shakbari.core.uikit.compose.ErrorView
import com.shakbari.core.uikit.compose.LoadingView
import com.shakbari.home.domain.entity.User
import com.shakbari.home.presentation.intent.UsersIntent
import com.shakbari.home.presentation.state.UserState
import com.shakbari.home.presentation.viewmodel.UsersViewModel
import com.shakbari.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect

@ExperimentalCoilApi
@Composable
internal fun HomeScreen(
    navController: NavController,
    usersViewModel: UsersViewModel
) {
    val context = LocalContext.current
    when (val state = usersViewModel.state.collectAsState().value) {
        is UserState.Idle -> usersViewModel.sendIntent(UsersIntent.GetUsers)
        is UserState.Loading -> LoadingView()
        is UserState.Error,is UserState.Empty -> ErrorView()
        is UserState.Users -> {
            LoadHomeScreenView2(
                navController = navController,
                users = state.users as ArrayList<User>
            )
        }
        is UserState.Users2 ->{
            state.users?.collectAsLazyPagingItems()?.let { userItems ->
                LoadHomeScreenView(
                    navController = navController,
                    users = userItems,
                    viewModel = usersViewModel
                )
            }
        }
    }

}

@ExperimentalCoilApi
@Composable
fun LoadHomeScreenView(navController: NavController, users: LazyPagingItems<User>, viewModel: UsersViewModel) {
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
/*        val listState = rememberLazyListState()
        val shouldLoadMore = remember {
            derivedStateOf {
                val lastVisibleItem = listState.layoutInfo.visibleItemsInfo.lastOrNull()
                    ?:
                    return@derivedStateOf true
                lastVisibleItem.index >=  listState.layoutInfo.totalItemsCount - 1 - 2
            }
        }.value*/
        LazyColumn(modifier = Modifier.background(Color.DarkGray)) {
            items(users.itemCount) { index ->
                val user = users.getAsState(index = index).value
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
                        viewModel.sendIntent(UsersIntent.GetUsers)
                    }
                }
            }

           /* if(shouldLoadMore){
                items(1) {
                    CircularProgressIndicator()
                    viewModel.updateUser(
                        users = ArrayList<User>().apply {
                            add(User())
                            add(User())
                            add(User())
                            add(User())
                            add(User())
                        }
                    )
                }
            }*/
        }
    }
}
@Composable
fun LazyListState.OnBottomReached(
    buffer : Int = 0,
    onLoadMore : () -> Unit
) {
    require(buffer >= 0) { "buffer cannot be negative, but was $buffer" }
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()
                ?:
                return@derivedStateOf true
            lastVisibleItem.index >=  layoutInfo.totalItemsCount - 1 - buffer
        }
    }

    LaunchedEffect(shouldLoadMore){
        snapshotFlow { shouldLoadMore.value }
            .collect {
                if (it) onLoadMore()
            }
    }
}


@ExperimentalCoilApi
@Composable
fun LoadHomeScreenView2(navController: NavController, users: ArrayList<User>) {
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



