package com.henrique.app.ui.brewerylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.henrique.app.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreweryListFragment : Fragment(R.layout.brewery_list_fragment) {

    private val viewModel by viewModel<BreweryListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
    }

    private fun setupObservers() {

    }

}