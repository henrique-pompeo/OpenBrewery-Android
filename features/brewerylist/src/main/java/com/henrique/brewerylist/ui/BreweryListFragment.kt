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
import com.henrique.shared.data.Result
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListFragment : Fragment(R.layout.brewery_list_fragment) {

    private var _binding: BreweryListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BreweryListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = BreweryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        getBreweries()
        binding.retryBt.setOnClickListener {
            getBreweries()
        }
    }

    private fun getBreweries() {
        with (viewModel) {
            getBreweries()
        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryList.observe(viewLifecycleOwner, { it ->
                when (it) {
                    is Result.Loading -> {
                        binding.breweryListLoadingPb.visibility = View.VISIBLE
                        binding.breweryListErrorCl.visibility = View.GONE
                        binding.breweryListRv.visibility = View.GONE
                    }
                    is Result.Success -> {
                        binding.breweryListLoadingPb.visibility = View.GONE
                        it.let {
                            val recyclerView = binding.breweryListRv
                            recyclerView.visibility = View.VISIBLE
                            recyclerView.layoutManager = LinearLayoutManager(requireContext())
                            recyclerView.adapter = BreweryListAdapter(it.data)
                            recyclerView.addItemDecoration(
                                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                            )
                        }
                    }
                    is Result.Error -> {
                        binding.breweryListLoadingPb.visibility = View.GONE
                        binding.breweryListRv.visibility = View.GONE
                        binding.breweryListErrorCl.visibility = View.VISIBLE
                        binding.errorTv.text = it.exception.message
                    }
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        binding.breweryListRv.adapter = null
    }

}
