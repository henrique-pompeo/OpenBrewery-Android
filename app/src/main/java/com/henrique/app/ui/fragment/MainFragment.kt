package com.henrique.app.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.henrique.app.R
import com.henrique.app.databinding.MainFragmentBinding

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
        with(binding) {
            activityMainBreweryListBt.setOnClickListener {
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToBrewerylistNav()
                )
            }
            activityMainBreweryDetailBt.setOnClickListener {
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToBreweryDetailFragmentMain(
                        binding.activityMainBreweryIdEt.text.toString()
                    )
                )
            }
            activityMainBreweryIdEt.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {}
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    binding.activityMainBreweryDetailBt.isEnabled = s.isNotEmpty()
                }
            })
        }
    }
}