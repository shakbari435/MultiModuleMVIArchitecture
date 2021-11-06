package com.shakbari.home.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u00070\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/shakbari/home/domain/repository/UserRepositoryImpl;", "Lcom/shakbari/home/domain/repository/UserRepository;", "retrofitApiHelper", "Lcom/shakbari/home/common/api/HomeApiHelper;", "(Lcom/shakbari/home/common/api/HomeApiHelper;)V", "getUsers", "Lkotlinx/coroutines/flow/Flow;", "Lcom/shakbari/core/base/DataState;", "Ljava/util/ArrayList;", "Lcom/shakbari/home/domain/entity/User;", "Lkotlin/collections/ArrayList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "home_debug"})
public final class UserRepositoryImpl implements com.shakbari.home.domain.repository.UserRepository {
    private final com.shakbari.home.common.api.HomeApiHelper retrofitApiHelper = null;
    
    @javax.inject.Inject()
    public UserRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.common.api.HomeApiHelper retrofitApiHelper) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getUsers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.shakbari.core.base.DataState<? extends java.util.ArrayList<com.shakbari.home.domain.entity.User>>>> continuation) {
        return null;
    }
}