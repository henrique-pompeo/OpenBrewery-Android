package com.henrique.brewerylist.ui.viewmodel;

import java.lang.System;

@org.koin.core.component.KoinApiExtension()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/henrique/brewerylist/ui/viewmodel/BreweryListViewModel;", "Lcom/henrique/shared/ui/base/BaseViewModel;", "breweryListRepository", "Lcom/henrique/brewerylist/data/repository/BreweryListRepository;", "(Lcom/henrique/brewerylist/data/repository/BreweryListRepository;)V", "breweryListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/henrique/shared/data/ResultStatus;", "", "Lcom/henrique/shared/domain/model/Brewery;", "getBreweryListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "viewModelJob", "Lkotlinx/coroutines/CompletableJob;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "getBreweryList", "", "brewerylist_debug"})
public final class BreweryListViewModel extends com.henrique.shared.ui.base.BaseViewModel {
    private final kotlinx.coroutines.CompletableJob viewModelJob = null;
    private final kotlinx.coroutines.CoroutineScope viewModelScope = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.henrique.shared.data.ResultStatus<java.util.List<com.henrique.shared.domain.model.Brewery>>> breweryListLiveData = null;
    private final com.henrique.brewerylist.data.repository.BreweryListRepository breweryListRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.henrique.shared.data.ResultStatus<java.util.List<com.henrique.shared.domain.model.Brewery>>> getBreweryListLiveData() {
        return null;
    }
    
    public final void getBreweryList() {
    }
    
    public BreweryListViewModel(@org.jetbrains.annotations.NotNull()
    com.henrique.brewerylist.data.repository.BreweryListRepository breweryListRepository) {
        super();
    }
}