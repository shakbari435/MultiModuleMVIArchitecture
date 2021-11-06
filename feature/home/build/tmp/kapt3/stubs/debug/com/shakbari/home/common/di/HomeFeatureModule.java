package com.shakbari.home.common.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/shakbari/home/common/di/HomeFeatureModule;", "", "()V", "provideApiHelper", "Lcom/shakbari/home/common/api/HomeApiHelper;", "apiHelper", "Lcom/shakbari/home/common/api/HomeApiHelperImpl;", "provideApiService", "Lcom/shakbari/home/common/api/HomeRetrofitApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideUserRepository", "Lcom/shakbari/home/domain/repository/UserRepository;", "userRepositoryImpl", "Lcom/shakbari/home/domain/repository/UserRepositoryImpl;", "home_debug"})
@dagger.Module()
public final class HomeFeatureModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.shakbari.home.common.di.HomeFeatureModule INSTANCE = null;
    
    private HomeFeatureModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.shakbari.home.common.api.HomeRetrofitApiService provideApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.shakbari.home.common.api.HomeApiHelper provideApiHelper(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.common.api.HomeApiHelperImpl apiHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.shakbari.home.domain.repository.UserRepository provideUserRepository(@org.jetbrains.annotations.NotNull()
    com.shakbari.home.domain.repository.UserRepositoryImpl userRepositoryImpl) {
        return null;
    }
}