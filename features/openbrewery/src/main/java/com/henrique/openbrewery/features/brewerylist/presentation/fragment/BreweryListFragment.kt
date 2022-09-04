package com.henrique.openbrewery.features.brewerylist.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.henrique.openbrewery.R
import com.henrique.openbrewery.databinding.BreweryListFragmentBinding
import com.henrique.openbrewery.features.brewerylist.presentation.viewmodel.BreweryListViewModel
import com.henrique.openbrewery.features.brewerylist.presentation.adapter.BreweryListAdapter
import com.henrique.datasource.brewerydetail.domain.model.BreweryStatus
import com.henrique.datasource.brewerydetail.domain.model.Brewery
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListFragment : Fragment(R.layout.brewery_list_fragment) {

    private lateinit var binding: BreweryListFragmentBinding
    private val viewModel by viewModel<BreweryListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = BreweryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservers()
        getBreweryList()
        binding.retryBt.setOnClickListener {
            getBreweryList()
        }
    }

    private fun setupAdapter() {
        binding.breweryListRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )

        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryListLiveData.observe(viewLifecycleOwner, {
                when (it) {
                    is BreweryStatus.Loading -> showLoading()
                    is BreweryStatus.Success -> showContent(it.data)
                    is BreweryStatus.Error -> showLayoutError(it.message)
                }
            })
        }
    }

    private fun getBreweryList() {
        viewModel.getBreweryList()
    }

    private fun showLoading() {
        updateLoadingVisibility(true)
        updateContentVisibility(false)
        updateLayoutErrorVisibility(false)
    }

    private fun showContent(breweryList: List<Brewery>) {
        updateAdapter(breweryList)
        updateLoadingVisibility(false)
        updateContentVisibility(true)
        updateLayoutErrorVisibility(false)
    }

    private fun showLayoutError(message: String?) {
        updateLoadingVisibility(false)
        updateContentVisibility(false)
        updateLayoutErrorVisibility(true)
        binding.errorTv.text = message
    }

    private fun updateAdapter(breweryList : List<Brewery>) {
        binding.breweryListRv.apply {
            isVisible = true
            adapter = BreweryListAdapter(breweryList, findNavController())
        }
    }

    private fun updateContentVisibility(visibility: Boolean) {
        binding.breweryListRv.isVisible = visibility
    }

    private fun updateLoadingVisibility(visibility: Boolean) {
        binding.breweryListLoadingPb.isVisible = visibility
    }

    private fun updateLayoutErrorVisibility(visibility: Boolean) {
        binding.breweryListErrorCl.isVisible = visibility
    }
}
