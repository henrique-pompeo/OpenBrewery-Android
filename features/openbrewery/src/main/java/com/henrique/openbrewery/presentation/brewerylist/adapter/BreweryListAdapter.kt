package com.henrique.openbrewery.presentation.brewerylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henrique.openbrewery.databinding.BreweryListItemBinding
import com.henrique.openbrewery.presentation.brewerylist.viewholder.BreweryListViewHolder
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListItem

class BreweryListAdapter(
    private val breweryList: List<BreweryListItem>,
    private val onItemClicked: (BreweryListItem) -> Unit
) : RecyclerView.Adapter<BreweryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryListViewHolder {
        return BreweryListViewHolder(
            BreweryListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = breweryList.size

    override fun onBindViewHolder(holder: BreweryListViewHolder, position: Int) {
        holder.bind(breweryList[position], onItemClicked)
    }
}
