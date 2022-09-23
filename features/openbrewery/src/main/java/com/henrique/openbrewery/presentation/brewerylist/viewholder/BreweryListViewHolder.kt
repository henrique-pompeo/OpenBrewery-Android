package com.henrique.openbrewery.presentation.brewerylist.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.henrique.openbrewery.databinding.BreweryListItemBinding
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListItem

class BreweryListViewHolder(
    private val binding: BreweryListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        breweryListItem: BreweryListItem,
        onItemClicked: (String) -> Unit
    ) {
        binding.apply {
            breweryListItemTitle.text = breweryListItem.name
            breweryListItemAddress.text = breweryListItem.address
            breweryListItemPhone.text = breweryListItem.phone
            root.setOnClickListener {
                onItemClicked(breweryListItem.id)
            }
        }
    }
}
