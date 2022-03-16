package com.shakbari.home.presentation.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tJ\u001e\u0010\u001c\u001a\u00020\u00162\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001ej\b\u0012\u0004\u0012\u00020\u0014`\u001fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "Landroidx/lifecycle/ViewModel;", "userUseCase", "Lcom/shakbari/home/domain/usecase/UserUseCase;", "userSource", "Lcom/shakbari/home/common/UserSource;", "(Lcom/shakbari/home/domain/usecase/UserUseCase;Lcom/shakbari/home/common/UserSource;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/shakbari/home/presentation/state/UserState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "userIntent", "Lkotlinx/coroutines/channels/Channel;", "Lcom/shakbari/home/presentation/intent/UsersIntent;", "getUserSource", "Landroidx/paging/Pager;", "", "Lcom/shakbari/home/domain/entity/User;", "getUsers", "", "intentHandler", "sendIntent", "usersIntent", "updateState", "userState", "updateUser", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "home_debug"})
public final class UsersViewModel extends androidx.lifecycle.ViewModel {
    private final com.shakbari.home.domain.usecase.UserUseCase userUseCase = null;
    private final com.shakbari.home.common.UserSource userSource = null;
    private final kotlinx.coroutines.channels.Channel<com.shakbari.home.presentation.intent.UsersIntent> userIntent = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shakbari.home.presentation.state.UserState> _state = null;
    
    @javax.inject.Inject()
    public UsersViewModel(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.usecase.UserUseCase userUseCase, @org.jetbrains.annotations.NotNull()
    com.shakbari.home.common.UserSource userSource) {
        super();
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
    
    public final void updateUser(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.shakbari.home.domain.entity.User> users) {
    }
    
    private final androidx.paging.Pager<java.lang.Integer, com.shakbari.home.domain.entity.User> getUserSource() {
        return null;
    }
}