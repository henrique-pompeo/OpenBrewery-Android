package com.henrique.app.ui.brewerylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henrique.app.databinding.BreweryItemBinding
import com.henrique.domain.model.Brewery

class BreweriesAdapter(var breweryList: List<Brewery>) :
    RecyclerView.Adapter<BreweriesAdapter.BreweryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweriesAdapter.BreweryViewHolder {
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