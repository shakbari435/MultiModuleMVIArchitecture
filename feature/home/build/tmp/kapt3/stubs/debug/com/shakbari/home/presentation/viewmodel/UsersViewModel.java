package com.shakbari.home.presentation.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "Landroidx/lifecycle/ViewModel;", "userUseCase", "Lcom/shakbari/home/domain/usecase/UserUseCase;", "(Lcom/shakbari/home/domain/usecase/UserUseCase;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/shakbari/home/presentation/state/UserState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "userIntent", "Lkotlinx/coroutines/channels/Channel;", "Lcom/shakbari/home/presentation/intent/UsersIntent;", "getUsers", "", "intentHandler", "sendIntent", "usersIntent", "updateState", "userState", "home_debug"})
public final class UsersViewModel extends androidx.lifecycle.ViewModel {
    private final com.shakbari.home.domain.usecase.UserUseCase userUseCase = null;
    private final kotlinx.coroutines.channels.Channel<com.shakbari.home.presentation.intent.UsersIntent> userIntent = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shakbari.home.presentation.state.UserState> _state = null;
    
    @javax.inject.Inject()
    public UsersViewModel(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.usecase.UserUseCase userUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.shakbari.home.presentation.state.UserState> getState() {
        return null;
    }
    
    private final void updateState(com.shakbari.home.presentation.state.UserState userState) {
    }
    
    public final void sendIntent(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.presentation.intent.UsersIntent usersIntent) {
    }
    
    private final void intentHandler() {
    }
    
    private final void getUsers() {
    }
}