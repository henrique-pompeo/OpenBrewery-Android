package com.henrique.brewerylist.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/henrique/brewerylist/data/repository/BreweryListRepository;", "", "getBreweryList", "Lcom/henrique/shared/data/ResultStatus;", "", "Lcom/henrique/shared/domain/model/Brewery;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertBreweryList", "", "breweryList", "Lcom/henrique/shared/data/database/entity/BreweryEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brewerylist_debug"})
public abstract interface BreweryListRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBreweryList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.henrique.shared.data.ResultStatus<? extends java.util.List<com.henrique.shared.domain.model.Brewery>>> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBreweryList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.henrique.shared.data.database.entity.BreweryEntity> breweryList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}