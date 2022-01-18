package com.henrique.openbreweryandroid.app.feature.brewerylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henrique.openbreweryandroid.databinding.BreweryItemBinding
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity

class BreweryListAdapter(var breweryList: List<BreweryEntity>) :
    RecyclerView.Adapter<BreweryListAdapter.BreweryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        val binding = BreweryItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BreweryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return breweryList.let { it.size }
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