package com.henrique.openbrewery.brewerylist.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.henrique.openbrewery.brewerylist.domain.mappers.BreweryListItemMapper
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListItem
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListState
import com.henrique.openbrewery.brewerylist.presentation.adapter.BreweryListAdapter
import com.henrique.openbrewery.brewerylist.presentation.viewmodel.BreweryListViewModel
import com.henrique.openbrewery.databinding.BreweryListFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreweryListFragment : Fragment() {

    private var binding: BreweryListFragmentBinding? = null
    private val viewModel: BreweryListViewModel by viewModel()
    private val breweryListItemMapper: BreweryListItemMapper by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = BreweryListFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
        loadBreweryList()
    }

    private fun setupListeners() {
        binding?.retryBt?.setOnClickListener {
            loadBreweryList()
        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryListState.observe(viewLifecycleOwner) {
                it?.let {
                    when (it) {
                        is BreweryListState.Loading -> updateScreen(showLoading = true)
                        is BreweryListState.Success -> updateScreen(breweryList =
                        breweryListItemMapper.toList(it.breweryList))
                        is BreweryListState.Error -> updateScreen(showError = true)
                    }
                }
            }
            clickedBrewery.observe(viewLifecycleOwner) {
                it?.let {
                    findNavController().navigate(
                        BreweryListFragmentDirections
                            .actionBreweryListFragmentToBreweryDetailFragment(id = it)
                    )
                }
            }
        }
    }

    private fun setupAdapter(breweryListItem: List<BreweryListItem>) {
        binding?.breweryListRv?.adapter = BreweryListAdapter(breweryListItem, ::onItemClicked)
    }

    private fun onItemClicked(id: String) {
        viewModel.itemClicked(id)
    }

    private fun loadBreweryList() {
        viewModel.getBreweryList()
    }

    private fun updateScreen(
        showLoading: Boolean = false,
        breweryList: List<BreweryListItem>? = null,
        showError: Boolean = false
    ) {
        showLoading(showLoading)
        breweryList?.let {
            setupAdapter(it)
            viewModel.clearStates()
        }
        showError(showError)
    }

    private fun showLoading(visibility: Boolean) {
        binding?.breweryListLoadingPb?.isVisible = visibility
    }

    private fun showError(visibility: Boolean) {
        binding?.breweryListErrorCl?.isVisible = visibility
    }
}
