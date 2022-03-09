package com.henrique.brewerylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.henrique.brewerylist.R
import com.henrique.brewerylist.databinding.BreweryListFragmentBinding
import com.henrique.shared.data.ResultStatus
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
        setupObservers()
        getBreweryList()
        binding.retryBt.setOnClickListener {
            getBreweryList()
        }
    }

    private fun getBreweryList() {
        with (viewModel) {
            getBreweryList()
        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryListLiveData.observe(viewLifecycleOwner, { it ->
                when (it) {
                    is ResultStatus.Loading -> {
                        binding.breweryListLoadingPb.visibility = View.VISIBLE
                        binding.breweryListErrorCl.visibility = View.GONE
                        binding.breweryListRv.visibility = View.GONE
                    }
                    is ResultStatus.Success -> {
                        binding.breweryListLoadingPb.visibility = View.GONE
                        it.let {
                            if (it.data.isNotEmpty()) {
                                binding.breweryListRv.apply {
                                    visibility = View.VISIBLE
                                    layoutManager = LinearLayoutManager(requireContext())
                                    adapter = BreweryListAdapter(it.data)
                                    addItemDecoration(
                                        DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                                    )
                                }
                            } else showLayoutError("No data available")
                        }
                    }
                    is ResultStatus.Error -> showLayoutError(it.exception.message)
                }
            })
        }
    }

    private fun showLayoutError(message: String?) {
        binding.breweryListLoadingPb.visibility = View.GONE
        binding.breweryListRv.visibility = View.GONE
        binding.breweryListErrorCl.visibility = View.VISIBLE
        binding.errorTv.text = message
    }
}
