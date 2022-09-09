package com.henrique.openbrewery.features.brewerylist.presentation.viewholder

import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.henrique.openbrewery.databinding.BreweryListItemBinding
import com.henrique.openbrewery.ui.fragment.BreweryListFragmentDirections
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

class BreweryListViewHolder(
    private val binding: BreweryListItemBinding,
    private val navController: NavController
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(brewery: BreweryDetail) {
        binding.apply {
            breweryListItemTitle.text = brewery.name
            breweryListItemAddress.text = brewery.country
            breweryListItemPhone.text = brewery.phone
            root.setOnClickListener {
                navController.navigate(
                    BreweryListFragmentDirections
                        .actionBreweryListFragmentToBreweryDetailFragment(brewery.id)
                )
            }
        }
    }
}