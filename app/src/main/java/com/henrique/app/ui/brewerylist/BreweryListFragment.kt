package com.henrique.app.ui.brewerylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.henrique.app.R
import com.henrique.app.databinding.BreweryListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreweryListFragment : Fragment(R.layout.brewery_list_fragment) {

    private var _binding: BreweryListFragmentBinding? = null
    private val binding get() = _binding!!

    private var mAdapter: BreweriesAdapter? = BreweriesAdapter()

    private val viewModel by viewModel<BreweryListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
    }

    private fun setupObservers() {

    }

}