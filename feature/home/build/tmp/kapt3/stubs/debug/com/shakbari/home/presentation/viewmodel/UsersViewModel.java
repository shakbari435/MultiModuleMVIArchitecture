package com.shakbari.home.presentation.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "Landroidx/lifecycle/ViewModel;", "userUseCase", "Lcom/shakbari/home/domain/usecase/UserUseCase;", "(Lcom/shakbari/home/domain/usecase/UserUseCase;)V", "_state", "Landroidx/compose/runtime/MutableState;", "Lcom/shakbari/home/presentation/state/UserListState;", "_state2", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_state3", "userState", "Landroidx/compose/runtime/State;", "getUserState", "()Landroidx/compose/runtime/State;", "userState2", "Lkotlinx/coroutines/flow/StateFlow;", "getUserState2", "()Lkotlinx/coroutines/flow/StateFlow;", "userState3", "Lkotlinx/coroutines/flow/SharedFlow;", "getUserState3", "()Lkotlinx/coroutines/flow/SharedFlow;", "getUsers", "", "getUsersTest", "home_debug"})
public final class UsersViewModel extends androidx.lifecycle.ViewModel {
    private final com.shakbari.home.domain.usecase.UserUseCase userUseCase = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shakbari.home.presentation.state.UserListState> _state2 = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.shakbari.home.presentation.state.UserListState> userState2 = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shakbari.home.presentation.state.UserListState> _state3 = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.shakbari.home.presentation.state.UserListState> userState3 = null;
    private final androidx.compose.runtime.MutableState<com.shakbari.home.presentation.state.UserListState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.shakbari.home.presentation.state.UserListState> userState = null;
    
    @javax.inject.Inject()
    public UsersViewModel(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.usecase.UserUseCase userUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.shakbari.home.presentation.state.UserListState> getUserState2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.shakbari.home.presentation.state.UserListState> getUserState3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.shakbari.home.presentation.state.UserListState> getUserState() {
        return null;
    }
    
    private final void getUsers() {
    }
    
    public final void getUsersTest() {
    }
}