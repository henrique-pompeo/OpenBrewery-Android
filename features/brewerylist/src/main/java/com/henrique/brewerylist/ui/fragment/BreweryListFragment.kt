package com.henrique.brewerylist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.henrique.brewerylist.R
import com.henrique.brewerylist.databinding.BreweryListFragmentBinding
import com.henrique.brewerylist.ui.viewmodel.BreweryListViewModel
import com.henrique.brewerylist.ui.adapter.BreweryListAdapter
import com.henrique.shared.data.ResultStatus
import com.henrique.shared.domain.model.Brewery
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListFragment : Fragment(R.layout.brewery_list_fragment) {

    private lateinit var binding: BreweryListFragmentBinding
    private val viewModel: BreweryListViewModel by viewModel()

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
            breweryListLiveData.observe(viewLifecycleOwner, { it ->
                when (it) {
                    is ResultStatus.Loading -> showLoading()
                    is ResultStatus.Success -> {
                        hideLoading()
                        if (it.data.isNotEmpty()) updateAdapter(it.data)
                        else showLayoutError("No data available")
                    }
                    is ResultStatus.Error -> showLayoutError(it.exception.message)
                }
            })
        }
    }

    private fun showLoading() {
        binding.apply {
            breweryListLoadingPb.isVisible = true
            breweryListErrorCl.isVisible = false
            breweryListRv.isVisible = false
        }
    }

    private fun hideLoading() {
        binding.breweryListLoadingPb.isVisible = false
    }

    private fun updateAdapter(breweryList : List<Brewery>) {
        binding.breweryListRv.apply {
            isVisible = true
            adapter = BreweryListAdapter(breweryList, findNavController())
        }
    }

    private fun getBreweryList() {
        viewModel.getBreweryList()
    }

    private fun showLayoutError(message: String?) {
        binding.apply {
            breweryListLoadingPb.isVisible = false
            breweryListRv.isVisible = false
            breweryListErrorCl.isVisible = true
            errorTv.text = message
        }
    }
}
