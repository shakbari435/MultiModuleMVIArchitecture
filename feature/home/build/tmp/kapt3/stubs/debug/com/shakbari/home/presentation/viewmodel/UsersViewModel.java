package com.shakbari.home.presentation.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\n\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\f0\u000bJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/shakbari/home/presentation/viewmodel/UsersViewModel;", "Landroidx/lifecycle/ViewModel;", "userUseCase", "Lcom/shakbari/home/domain/usecase/UserUseCase;", "(Lcom/shakbari/home/domain/usecase/UserUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/shakbari/core/base/Resource$Companion;", "get_uiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "getUsers", "Lkotlinx/coroutines/flow/Flow;", "Lcom/shakbari/core/base/ViewState;", "Ljava/util/ArrayList;", "Lcom/shakbari/home/domain/entity/User;", "Lkotlin/collections/ArrayList;", "getUsers2", "Lcom/shakbari/core/base/UiState;", "UserState", "home_debug"})
public final class UsersViewModel extends androidx.lifecycle.ViewModel {
    private final com.shakbari.home.domain.usecase.UserUseCase userUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shakbari.core.base.Resource.Companion> _uiState = null;
    
    @javax.inject.Inject()
    public UsersViewModel(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.usecase.UserUseCase userUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.shakbari.core.base.Resource.Companion> get_uiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.shakbari.core.base.ViewState<java.util.ArrayList<com.shakbari.home.domain.entity.User>>> getUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.shakbari.core.base.UiState> getUsers2() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c6\u0003J#\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/shakbari/home/presentation/viewmodel/UsersViewModel$UserState;", "", "recipes", "", "Lcom/shakbari/home/domain/entity/User;", "isEmpty", "", "(Ljava/util/List;Z)V", "()Z", "getRecipes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "home_debug"})
    public static final class UserState {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.shakbari.home.domain.entity.User> recipes = null;
        private final boolean isEmpty = false;
        
        @org.jetbrains.annotations.NotNull()
        public final com.shakbari.home.presentation.viewmodel.UsersViewModel.UserState copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.shakbari.home.domain.entity.User> recipes, boolean isEmpty) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public UserState() {
            super();
        }
        
        public UserState(@org.jetbrains.annotations.NotNull()
        java.util.List<com.shakbari.home.domain.entity.User> recipes, boolean isEmpty) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.shakbari.home.domain.entity.User> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.shakbari.home.domain.entity.User> getRecipes() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean isEmpty() {
            return false;
        }
    }
}