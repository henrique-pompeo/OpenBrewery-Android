package com.henrique.brewerylist.data.datasource.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/henrique/brewerylist/data/datasource/local/BreweryListLocalDataSource;", "", "getBreweryList", "", "Lcom/henrique/shared/data/database/entity/BreweryEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertBreweryList", "", "breweryList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brewerylist_debug"})
public abstract interface BreweryListLocalDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBreweryList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.henrique.shared.data.database.entity.BreweryEntity>> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBreweryList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.henrique.shared.data.database.entity.BreweryEntity> breweryList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}