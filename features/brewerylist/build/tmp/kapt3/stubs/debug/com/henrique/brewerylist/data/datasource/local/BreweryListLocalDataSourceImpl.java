package com.henrique.brewerylist.data.datasource.local;

import java.lang.System;

@org.koin.core.component.KoinApiExtension()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/henrique/brewerylist/data/datasource/local/BreweryListLocalDataSourceImpl;", "Lorg/koin/core/component/KoinComponent;", "Lcom/henrique/brewerylist/data/datasource/local/BreweryListLocalDataSource;", "breweryDao", "Lcom/henrique/shared/data/database/dao/BreweryDao;", "(Lcom/henrique/shared/data/database/dao/BreweryDao;)V", "getBreweryList", "", "Lcom/henrique/shared/data/database/entity/BreweryEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertBreweryList", "", "breweryList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brewerylist_debug"})
public final class BreweryListLocalDataSourceImpl implements org.koin.core.component.KoinComponent, com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSource {
    private final com.henrique.shared.data.database.dao.BreweryDao breweryDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBreweryList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.henrique.shared.data.database.entity.BreweryEntity>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertBreweryList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.henrique.shared.data.database.entity.BreweryEntity> breweryList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public BreweryListLocalDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.henrique.shared.data.database.dao.BreweryDao breweryDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.koin.core.Koin getKoin() {
        return null;
    }
}