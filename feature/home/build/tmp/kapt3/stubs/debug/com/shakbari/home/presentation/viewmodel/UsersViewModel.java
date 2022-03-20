package com.shakbari.home.presentation.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "Lcom/shakbari/core/base/mvi/BaseViewModel;", "Lcom/shakbari/home/presentation/contract/HomeContract$Intent;", "Lcom/shakbari/home/presentation/contract/HomeContract$ScreenState;", "userUseCase", "Lcom/shakbari/home/domain/usecase/UserUseCase;", "(Lcom/shakbari/home/domain/usecase/UserUseCase;)V", "_users", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/shakbari/home/domain/entity/User;", "isLoadMoreLoading", "Landroidx/compose/runtime/MutableState;", "", "()Landroidx/compose/runtime/MutableState;", "setLoadMoreLoading", "(Landroidx/compose/runtime/MutableState;)V", "createInitialState", "getUsers", "", "getUsersWithPaging", "handleIntent", "intent", "home_debug"})
public final class UsersViewModel extends com.shakbari.core.base.mvi.BaseViewModel<com.shakbari.home.presentation.contract.HomeContract.Intent, com.shakbari.home.presentation.contract.HomeContract.ScreenState> {
    private final com.shakbari.home.domain.usecase.UserUseCase userUseCase = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.shakbari.home.domain.entity.User>> _users = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isLoadMoreLoading;
    
    @javax.inject.Inject()
    public UsersViewModel(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.usecase.UserUseCase userUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isLoadMoreLoading() {
        return null;
    }
    
    public final void setLoadMoreLoading(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.shakbari.home.presentation.contract.HomeContract.ScreenState createInitialState() {
        return null;
    }
    
    @java.lang.Override()
    public void handleIntent(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.contract.HomeContract.Intent intent) {
    }
    
    private final void getUsers() {
    }
    
    private final void getUsersWithPaging() {
    }
}