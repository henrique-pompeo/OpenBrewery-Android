package com.henrique.brewerylist.ui.viewholder

import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.henrique.brewerylist.databinding.BreweryListItemBinding
import com.henrique.brewerylist.ui.fragment.BreweryListFragmentDirections
import com.henrique.shared.domain.model.Brewery

class BreweryListViewHolder(
    private val binding: BreweryListItemBinding,
    private val navController: NavController
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(brewery: Brewery) {
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