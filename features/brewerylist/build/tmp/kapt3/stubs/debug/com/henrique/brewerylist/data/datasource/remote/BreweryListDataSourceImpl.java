package com.henrique.brewerylist.data.datasource.remote;

import java.lang.System;

@org.koin.core.component.KoinApiExtension()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/henrique/brewerylist/data/datasource/remote/BreweryListDataSourceImpl;", "Lorg/koin/core/component/KoinComponent;", "Lcom/henrique/brewerylist/data/datasource/remote/BreweryListDataSource;", "breweryListService", "Lcom/henrique/brewerylist/data/service/BreweryListService;", "(Lcom/henrique/brewerylist/data/service/BreweryListService;)V", "getBreweryList", "", "Lcom/henrique/shared/data/remote/response/BreweryResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brewerylist_debug"})
public final class BreweryListDataSourceImpl implements org.koin.core.component.KoinComponent, com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource {
    private final com.henrique.brewerylist.data.service.BreweryListService breweryListService = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBreweryList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.henrique.shared.data.remote.response.BreweryResponse>> p0) {
        return null;
    }
    
    public BreweryListDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.henrique.brewerylist.data.service.BreweryListService breweryListService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.koin.core.Koin getKoin() {
        return null;
    }
}