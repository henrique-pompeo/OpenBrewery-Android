package com.henrique.brewerylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
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

    private val viewModel: BreweryListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = BreweryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        getBreweries()
    }

    private fun getBreweries() {
        with (viewModel) {
            getBreweries()
        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryList.observe(viewLifecycleOwner, { it ->
                it?.let {
                    val recyclerView = binding.breweryListRv
                    recyclerView.layoutManager = LinearLayoutManager(requireContext())
                    recyclerView.adapter = BreweryListAdapter(it)
                    recyclerView.addItemDecoration(
                        DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                    )
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
