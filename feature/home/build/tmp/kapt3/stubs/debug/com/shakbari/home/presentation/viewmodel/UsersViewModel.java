package com.shakbari.home.presentation.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018H\u0002J\b\u0010\u0015\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "Landroidx/lifecycle/ViewModel;", "userUseCase", "Lcom/shakbari/home/domain/usecase/UserUseCase;", "userSource", "Lcom/shakbari/home/common/UserSource;", "(Lcom/shakbari/home/domain/usecase/UserUseCase;Lcom/shakbari/home/common/UserSource;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/shakbari/home/presentation/state/UserState;", "_users", "Landroidx/paging/PagingData;", "Lcom/shakbari/home/domain/entity/User;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "userIntent", "Lkotlinx/coroutines/channels/Channel;", "Lcom/shakbari/home/presentation/intent/UsersIntent;", "users", "getUsers", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "getUserSource", "Landroidx/paging/Pager;", "", "", "intentHandler", "sendIntent", "usersIntent", "updateState", "userState", "home_debug"})
public final class UsersViewModel extends androidx.lifecycle.ViewModel {
    private final com.shakbari.home.domain.usecase.UserUseCase userUseCase = null;
    private final com.shakbari.home.common.UserSource userSource = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.paging.PagingData<com.shakbari.home.domain.entity.User>> _users = null;
    private final kotlinx.coroutines.channels.Channel<com.shakbari.home.presentation.intent.UsersIntent> userIntent = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shakbari.home.presentation.state.UserState> _state = null;
    
    @javax.inject.Inject()
    public UsersViewModel(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.usecase.UserUseCase userUseCase, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.common.UserSource userSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<androidx.paging.PagingData<com.shakbari.home.domain.entity.User>> getUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.shakbari.home.presentation.state.UserState> getState() {
        return null;
    }
    
    public final void updateState(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.state.UserState userState) {
    }
    
    public final void sendIntent(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.intent.UsersIntent usersIntent) {
    }
    
    private final void intentHandler() {
    }
    
    private final void getUsers() {
    }
    
    private final androidx.paging.Pager<java.lang.Integer, com.shakbari.home.domain.entity.User> getUserSource() {
        return null;
    }
}