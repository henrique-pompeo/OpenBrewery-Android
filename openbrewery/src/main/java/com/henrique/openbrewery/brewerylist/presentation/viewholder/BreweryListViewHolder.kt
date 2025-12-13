package com.henrique.openbrewery.brewerylist.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.henrique.openbrewery.brewerylist.domain.model.BreweryAddress
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListItem
import com.henrique.openbrewery.databinding.BreweryListItemBinding

internal class BreweryListViewHolder(
    private val binding: BreweryListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(
        breweryListItem: BreweryListItem,
        onItemClicked: (String) -> Unit
    ) {
        binding.apply {
            breweryListItemTitle.text = breweryListItem.name
            breweryListItemAddress.text = getAddress(breweryListItem.address)

            root.setOnClickListener {
                onItemClicked(breweryListItem.id)
            }
        }
    }

    private fun getAddress(breweryAddress: BreweryAddress): String {
        return with(breweryAddress){
            "$address1, $address2, $address3, $city, $stateProvince, $postalCode, $country, $street"
        }
    }
}
