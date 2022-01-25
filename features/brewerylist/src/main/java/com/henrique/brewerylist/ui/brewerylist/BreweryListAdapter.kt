package com.henrique.brewerylist.ui.brewerylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henrique.brewerylist.databinding.BreweryListItemBinding
import com.henrique.brewerylist.domain.model.Brewery

class BreweryListAdapter(private var breweryList: List<Brewery>) :
    RecyclerView.Adapter<BreweryListAdapter.BreweryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        val binding = BreweryListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BreweryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return breweryList.size
    }

    inner class BreweryViewHolder(val binding: BreweryListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        with(holder) {
            with (breweryList[position]) {
                binding.breweryListItemTitle.text = this.name
                binding.breweryListItemAddress.text = this.country
                binding.breweryListItemPhone.text = this.phone
            }
        }
    }
}