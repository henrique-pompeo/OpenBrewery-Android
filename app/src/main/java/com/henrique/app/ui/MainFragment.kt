package com.henrique.app.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.henrique.app.R
import com.henrique.app.databinding.MainFragmentBinding
import com.henrique.brewerylist.databinding.BreweryListFragmentBinding
import com.henrique.brewerylist.ui.BreweryListFragmentDirections

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupComponent()
    }

    private fun setupComponent() {
        binding.activityMainBreweryListBt.setOnClickListener {
            val action = MainFragmentDirections
                .actionMainFragmentToBrewerylistNav()
            findNavController().navigate(action)
        }
        binding.activityMainBreweryDetailBt.setOnClickListener {
            val action = MainFragmentDirections
                .actionMainFragmentToBreweryDetailFragmentMain(
                    binding.activityMainBreweryIdEt.text.toString()
                )
            findNavController().navigate(action)
        }
        binding.activityMainBreweryIdEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                binding.activityMainBreweryDetailBt.isEnabled = s.isNotEmpty()
            }
        })
    }

}