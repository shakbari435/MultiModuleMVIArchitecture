package com.shakbari.home.presentation.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a&\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH\u0007\u001a \u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0012"}, d2 = {"HomeScreen", "", "navController", "Landroidx/navigation/NavController;", "usersViewModel", "Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "LoadHomeScreenView2", "users", "", "Lcom/shakbari/home/domain/entity/User;", "SideEffectHandler", "effectState", "Lcom/shakbari/home/presentation/contract/HomeContract$SideEffect;", "UserCardView", "user", "UsersStateHandler", "userState", "Lcom/shakbari/home/presentation/contract/HomeContract$UsersState;", "home_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable()
    @coil.annotation.ExperimentalCoilApi()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.viewmodel.UsersViewModel usersViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SideEffectHandler(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.contract.HomeContract.SideEffect effectState) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {coil.annotation.ExperimentalCoilApi.class})
    public static final void UsersStateHandler(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.contract.HomeContract.UsersState userState, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.viewmodel.UsersViewModel usersViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    @coil.annotation.ExperimentalCoilApi()
    public static final void LoadHomeScreenView2(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shakbari.home.domain.entity.User> users, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.viewmodel.UsersViewModel usersViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {coil.annotation.ExperimentalCoilApi.class})
    public static final void UserCardView(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.entity.User user) {
    }
}