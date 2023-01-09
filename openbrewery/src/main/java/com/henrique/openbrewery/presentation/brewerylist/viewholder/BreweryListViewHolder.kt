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

            breweryListItemType.text = breweryListItem.type
            breweryListItemType.tooltipText = breweryListItem.type?.let { getTypeTooltipText(it) }

            breweryListItemDistance.isVisible = !breweryListItem.distance.equals("0.00")
            breweryListItemDistanceIcon.isVisible = !breweryListItem.distance.equals("0.00")
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

    private fun getTypeTooltipText(breweryType: String) : String {
        return when (breweryType) {
            "micro" -> "Most craft breweries. For example, Samual Adams is still considered a micro brewery."
            "nano" -> "An extremely small brewery which typically only distributes locally."
            "regional" -> "A regional location of an expanded brewery. Ex. Sierra Nevada’s Asheville, NC location."
            "brewpub" -> "A beer-focused restaurant or restaurant/bar with a brewery on-premise."
            "large" -> "A very large brewery. Likely not for visitors. Ex. Miller-Coors. (deprecated)"
            "planning" -> "A brewery in planning or not yet opened to the public."
            "bar" -> "A bar. No brewery equipment on premise. (deprecated)"
            "contract" -> "A brewery that uses another brewery’s equipment."
            "proprietor" -> "Similar to contract brewing but refers more to a brewery incubator."
            "closed" -> "A location which has been closed."
            else -> "type"
        }
    }
}
