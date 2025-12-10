package com.henrique.openbrewery.presentation.brewerylist.viewholder

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.henrique.openbrewery.R
import com.henrique.openbrewery.databinding.BreweryListItemBinding
import com.henrique.openbrewery.domain.brewerylist.model.BreweryAddress
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
            breweryListItemAddress.text = getAddress(breweryListItem.address)

            breweryListItemDistance.isVisible = !breweryListItem.distance.equals("0.00")
            if (!breweryListItem.distance.equals("0.00")) {
                breweryListItemDistance.text =
                    this.root.context.getString(R.string.distance_km, breweryListItem.distance)
            }

            root.setOnClickListener {
                onItemClicked(breweryListItem.id)
            }
        }
    }

    private fun getAddress(breweryAddress: BreweryAddress?) : String {
        return  breweryAddress?.run {
            street?.plus(", ").orEmpty() +
            address2?.plus(", ").orEmpty() +
            address3?.plus(", ").orEmpty() +
            city?.plus("- ").orEmpty() +
            state?.plus(", ").orEmpty() +
            countyProvince?.plus("- ").orEmpty() +
            postalCode?.plus("- ").orEmpty() +
            country.orEmpty()
        }.toString()
    }
}
