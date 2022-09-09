package com.henrique.brewerylist.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/henrique/brewerylist/ui/adapter/BreweryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/henrique/brewerylist/ui/viewholder/BreweryListViewHolder;", "breweryList", "", "Lcom/henrique/shared/domain/model/Brewery;", "navController", "Landroidx/navigation/NavController;", "(Ljava/util/List;Landroidx/navigation/NavController;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "brewerylist_debug"})
public final class BreweryListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.henrique.brewerylist.ui.viewholder.BreweryListViewHolder> {
    private java.util.List<com.henrique.shared.domain.model.Brewery> breweryList;
    private androidx.navigation.NavController navController;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.henrique.brewerylist.ui.viewholder.BreweryListViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.henrique.brewerylist.ui.viewholder.BreweryListViewHolder holder, int position) {
    }
    
    public BreweryListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.henrique.shared.domain.model.Brewery> breweryList, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
        super();
    }
}