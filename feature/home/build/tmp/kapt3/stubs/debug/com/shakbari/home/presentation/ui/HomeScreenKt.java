package com.shakbari.home.presentation.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a&\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0005H\u0007\u001a(\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\rH\u0007\u001a$\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007\u00a8\u0006\u0014"}, d2 = {"HomeScreen", "", "navController", "Landroidx/navigation/NavController;", "usersViewModel", "Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "LoadHomeScreenView", "users", "Landroidx/paging/compose/LazyPagingItems;", "Lcom/shakbari/home/domain/entity/User;", "viewModel", "LoadHomeScreenView2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "OnBottomReached", "Landroidx/compose/foundation/lazy/LazyListState;", "buffer", "", "onLoadMore", "Lkotlin/Function0;", "home_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable()
    @coil.annotation.ExperimentalCoilApi()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.viewmodel.UsersViewModel usersViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    @coil.annotation.ExperimentalCoilApi()
    public static final void LoadHomeScreenView(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    androidx.paging.compose.LazyPagingItems<com.shakbari.home.domain.entity.User> users, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.viewmodel.UsersViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void OnBottomReached(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.lazy.LazyListState $this$OnBottomReached, int buffer, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLoadMore) {
    }
    
    @androidx.compose.runtime.Composable()
    @coil.annotation.ExperimentalCoilApi()
    public static final void LoadHomeScreenView2(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.shakbari.home.domain.entity.User> users) {
    }
}