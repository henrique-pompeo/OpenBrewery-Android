package com.henrique.app.ui.brewerylist

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.henrique.app.R
import com.henrique.app.databinding.BreweryListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListFragment : Fragment(R.layout.brewery_list_fragment) {

    private var _binding: BreweryListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var breweriesAdapter: BreweriesAdapter

    private val viewModel by viewModel<BreweryListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = BreweryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBreweries()
        setupObservers()
    }

    private fun getBreweries() {
       viewModel.getBreweries()
    }

    private fun setupObservers() {
        with (viewModel) {
            breweriesData.observe(viewLifecycleOwner, {
                it?.let {
                    breweriesAdapter = BreweriesAdapter(it)
                    binding.breweryList.adapter = breweriesAdapter
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}