package com.henrique.brewerydetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.henrique.brewerydetail.R
import com.henrique.brewerydetail.databinding.BreweryDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryDetailFragment : Fragment(R.layout.brewery_detail_fragment) {

    private lateinit var binding: BreweryDetailFragmentBinding

    private val viewModel: BreweryDetailViewModel by viewModel()

    private val args: BreweryDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = BreweryDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        getBreweryById(args.id)
    }

    private fun getBreweryById(id: String) {
        with (viewModel) {
            getBreweryById(id)
        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryDetail.observe(viewLifecycleOwner, {
                it?.let {

                    binding.breweryDetailFragmentBreweryNameTv.text = it.name
                    binding.breweryDetailFragmentBreweryTypeTv.text = it.breweryType

                    binding.breweryDetailFragmentBreweryStreetTv.text = getString(
                        R.string.brewery_street, it.street
                    )
                    binding.breweryDetailFragmentBreweryAddress2Tv.text = getString(
                        R.string.brewery_address2, it.address2
                    )
                    binding.breweryDetailFragmentBreweryAddress3Tv.text = getString(
                        R.string.brewery_address3, it.address3
                    )
                    binding.breweryDetailFragmentBreweryCityTv.text = getString(
                        R.string.brewery_city, it.city
                    )
                    binding.breweryDetailFragmentBreweryStateTv.text = getString(
                        R.string.brewery_state, it.state
                    )
                    binding.breweryDetailFragmentBreweryCountyProvinceTv.text = getString(
                        R.string.brewery_county_province, it.countyProvince
                    )
                    binding.breweryDetailFragmentBreweryPostalCodeTv.text = getString(
                        R.string.brewery_postal_code, it.postalCode
                    )
                    binding.breweryDetailFragmentBreweryCountryTv.text = getString(
                        R.string.brewery_country, it.country
                    )

                    binding.breweryDetailFragmentBreweryPhoneTv.text = getString(
                        R.string.brewery_phone, it.phone
                    )
                    binding.breweryDetailFragmentBreweryWebsiteUrlTv.text = getString(
                        R.string.brewery_website_url, it.websiteUrl
                    )
                }
            })
        }
    }
}