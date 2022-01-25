package com.henrique.brewerylist.ui.brewerylist

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.henrique.brewerylist.R
import com.henrique.brewerylist.databinding.BreweryListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListFragment : Fragment(R.layout.brewery_list_fragment) {

    private var _binding: BreweryListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var breweryListAdapter: BreweryListAdapter

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    private val viewModel: BreweryListViewModel by viewModel()

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
        with (viewModel) {
            getBreweries()
        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryList.observe(viewLifecycleOwner, {
                it?.let {
                    breweryListAdapter = BreweryListAdapter(it)
                    binding.breweryList.adapter = breweryListAdapter
                    binding.breweryList.layoutManager = layoutManager
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        binding.breweryList.adapter = null
    }

}
