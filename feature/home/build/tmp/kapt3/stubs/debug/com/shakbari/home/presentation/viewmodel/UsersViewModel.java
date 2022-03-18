package com.shakbari.home.presentation.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0003H\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "Lcom/shakbari/core/base/mvi/BaseViewModel;", "Lcom/shakbari/home/presentation/contract/HomeContract$Intent;", "Lcom/shakbari/home/presentation/contract/HomeContract$ScreenState;", "userUseCase", "Lcom/shakbari/home/domain/usecase/UserUseCase;", "userSource", "Lcom/shakbari/home/presentation/pagination/UserSource;", "(Lcom/shakbari/home/domain/usecase/UserUseCase;Lcom/shakbari/home/presentation/pagination/UserSource;)V", "_users", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/paging/PagingData;", "Lcom/shakbari/home/domain/entity/User;", "createInitialState", "getUserSource", "Landroidx/paging/Pager;", "", "getUsers", "", "getUsersWithPaging", "handleIntent", "intent", "home_debug"})
public final class UsersViewModel extends com.shakbari.core.base.mvi.BaseViewModel<com.shakbari.home.presentation.contract.HomeContract.Intent, com.shakbari.home.presentation.contract.HomeContract.ScreenState> {
    private final com.shakbari.home.domain.usecase.UserUseCase userUseCase = null;
    private final com.shakbari.home.presentation.pagination.UserSource userSource = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.paging.PagingData<com.shakbari.home.domain.entity.User>> _users = null;
    
    @javax.inject.Inject()
    public UsersViewModel(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.usecase.UserUseCase userUseCase, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.pagination.UserSource userSource) {
        super();
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
    
    private final androidx.paging.Pager<java.lang.Integer, com.shakbari.home.domain.entity.User> getUserSource() {
        return null;
    }
}