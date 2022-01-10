package com.henrique.app.ui.brewerylist

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.henrique.app.R
import com.henrique.app.databinding.BreweryListFragmentBinding
import com.henrique.domain.model.Brewery
import kotlin.properties.Delegates

class BreweriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mBreweryList: List<Brewery> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    private lateinit var binding: BreweryListFragmentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderBrewery = BreweryListFragmentBinding.inflate(LayoutInflater.from(parent.context))
        return BreweryListViewM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    private inner class BreweryViewHolder(private val viewBinding: ViewBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        }
}