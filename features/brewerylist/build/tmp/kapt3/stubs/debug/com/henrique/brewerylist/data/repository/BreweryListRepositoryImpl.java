package com.henrique.brewerylist.data.repository;

import java.lang.System;

@org.koin.core.component.KoinApiExtension()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/henrique/brewerylist/data/repository/BreweryListRepositoryImpl;", "Lorg/koin/core/component/KoinComponent;", "Lcom/henrique/brewerylist/data/repository/BreweryListRepository;", "breweryListDataSource", "Lcom/henrique/brewerylist/data/datasource/remote/BreweryListDataSource;", "breweryListLocalDataSource", "Lcom/henrique/brewerylist/data/datasource/local/BreweryListLocalDataSource;", "(Lcom/henrique/brewerylist/data/datasource/remote/BreweryListDataSource;Lcom/henrique/brewerylist/data/datasource/local/BreweryListLocalDataSource;)V", "getBreweryList", "Lcom/henrique/shared/data/ResultStatus;", "", "Lcom/henrique/shared/domain/model/Brewery;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertBreweryList", "", "breweryList", "Lcom/henrique/shared/data/database/entity/BreweryEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brewerylist_debug"})
public final class BreweryListRepositoryImpl implements org.koin.core.component.KoinComponent, com.henrique.brewerylist.data.repository.BreweryListRepository {
    private final com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource breweryListDataSource = null;
    private final com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSource breweryListLocalDataSource = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBreweryList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.henrique.shared.data.ResultStatus<? extends java.util.List<com.henrique.shared.domain.model.Brewery>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertBreweryList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.henrique.shared.data.database.entity.BreweryEntity> breweryList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public BreweryListRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource breweryListDataSource, @org.jetbrains.annotations.NotNull()
    com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSource breweryListLocalDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.koin.core.Koin getKoin() {
        return null;
    }
}