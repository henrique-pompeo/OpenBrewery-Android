package com.henrique.brewerylist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.henrique.brewerylist.databinding.BreweryListItemBinding
import com.henrique.brewerylist.ui.viewholder.BreweryListViewHolder
import com.henrique.shared.domain.model.Brewery

class BreweryListAdapter(
    private var breweryList: List<Brewery> = listOf(),
    private var navController: NavController
) : RecyclerView.Adapter<BreweryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryListViewHolder {
        val binding = BreweryListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BreweryListViewHolder(binding, navController)
    }

    override fun getItemCount(): Int = breweryList.size

    override fun onBindViewHolder(holder: BreweryListViewHolder, position: Int) {
        holder.bind(breweryList[position])
    }
}