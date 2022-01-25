package com.henrique.brewerylist.ui.brewerylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henrique.brewerylist.databinding.BreweryItemBinding
import com.henrique.brewerylist.domain.model.Brewery

class BreweryListAdapter(private var breweryList: List<Brewery>) :
    RecyclerView.Adapter<BreweryListAdapter.BreweryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        val binding = BreweryItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BreweryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return breweryList.size
    }

    inner class BreweryViewHolder(val binding: BreweryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        with(holder) {
            with (breweryList[position]) {
                binding.breweryTitle.text = this.name
                binding.breweryAddress.text = this.country
                binding.breweryPhone.text = this.phone
            }
        }
    }
}