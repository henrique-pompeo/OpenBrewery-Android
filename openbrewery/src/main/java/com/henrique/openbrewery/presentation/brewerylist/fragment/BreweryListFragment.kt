package com.henrique.openbrewery.presentation.brewerylist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.henrique.openbrewery.R
import com.henrique.openbrewery.databinding.BreweryListFragmentBinding
import com.henrique.openbrewery.domain.brewerylist.mappers.BreweryListItemMapper
import com.henrique.openbrewery.presentation.brewerylist.adapter.BreweryListAdapter
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListItem
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListState
import com.henrique.openbrewery.domain.navigation.BreweryNavigation
import com.henrique.openbrewery.presentation.brewerylist.viewmodel.BreweryListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.navigation.koinNavGraphViewModel

class BreweryListFragment : Fragment() {

    private lateinit var binding: BreweryListFragmentBinding
    private val viewModel: BreweryListViewModel by koinNavGraphViewModel(R.id.openbrewery_navigation)
    private val breweryNavigation: BreweryNavigation by inject()
    private val breweryListItemMapper: BreweryListItemMapper by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = BreweryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
        binding.retryBt.setOnClickListener {
            reloadBreweryList()
        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryListState.observe(viewLifecycleOwner) {
                when (it) {
                    is BreweryListState.Loading -> updateScreen(showLoading = true)
                    is BreweryListState.Success -> updateScreen(
                        breweryList = breweryListItemMapper.toList(it.breweryList)
                    )
                    is BreweryListState.Error -> updateScreen(showError = true)
                }
            }
            clickedBrewery.observe(viewLifecycleOwner) {
                breweryNavigation.goToBreweryDetails()
            }
        }
    }

    private fun setupAdapter(breweryListItem: List<BreweryListItem>) {
        binding.breweryListRv.apply {
            adapter = BreweryListAdapter(breweryListItem, ::onItemClicked)
        }
    }

    private fun onItemClicked(id: String) {
        viewModel.itemClicked(id)
    }

    private fun reloadBreweryList() {
        viewModel.getBreweryList()
    }

    private fun updateScreen(
        showLoading: Boolean = false,
        breweryList: List<BreweryListItem>? = null,
        showError: Boolean = false
    ) {
        showLoading(showLoading)
        breweryList?.let { setupAdapter(it) }
        showError(showError)
    }

    private fun showLoading(visibility: Boolean) {
        binding.breweryListLoadingPb.isVisible = visibility
    }

    private fun showError(visibility: Boolean) {
        binding.breweryListErrorCl.isVisible = visibility
    }
}
