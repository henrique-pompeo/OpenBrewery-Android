package com.henrique.brewerydetail.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.henrique.brewerydetail.R
import com.henrique.brewerydetail.databinding.BreweryDetailFragmentBinding
import com.henrique.brewerydetail.ui.viewmodel.BreweryDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.henrique.shared.data.ResultStatus
import com.henrique.shared.domain.model.Brewery
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
        binding.retryBt.setOnClickListener {
            getBreweryById(args.id)
        }
    }

    private fun getBreweryById(id: String) {
        with (viewModel) {
            getBreweryById(id)
        }
    }

    private fun setupObservers() {
        with (viewModel) {
            breweryDetailLiveData.observe(viewLifecycleOwner, {
                when (it) {
                    is ResultStatus.Loading -> showLoading()
                    is ResultStatus.Success -> showContent(it.data)
                    is ResultStatus.Error -> showLayoutError(it.message)
                }
            })
        }
    }

    private fun showLoading() {
        updateLoadingVisibility(true)
        updateContentVisibility(false)
        updateLayoutErrorVisibility(false)
    }

    private fun showContent(brewery: Brewery) {
        updateFields(brewery)
        updateLoadingVisibility(false)
        updateContentVisibility(true)
        updateLayoutErrorVisibility(false)
    }

    private fun showLayoutError(message: String?) {
        updateLoadingVisibility(false)
        updateContentVisibility(false)
        updateLayoutErrorVisibility(true)
        binding.errorTv.text = message
    }

    private fun updateFields(brewery: Brewery) {
        with(binding) {
            breweryDetailFragmentBreweryNameTv.text = brewery.name
            breweryDetailFragmentBreweryTypeTv.text = brewery.breweryType
            breweryDetailFragmentBreweryStreetTv.text = getString(
                R.string.brewery_street, brewery.street
            )
            breweryDetailFragmentBreweryAddress2Tv.text = getString(
                R.string.brewery_address2, brewery.address2
            )
            breweryDetailFragmentBreweryAddress3Tv.text = getString(
                R.string.brewery_address3, brewery.address3
            )
            breweryDetailFragmentBreweryCityTv.text = getString(
                R.string.brewery_city, brewery.city
            )
            breweryDetailFragmentBreweryStateTv.text = getString(
                R.string.brewery_state, brewery.state
            )
            breweryDetailFragmentBreweryCountyProvinceTv.text = getString(
                R.string.brewery_county_province, brewery.countyProvince
            )
            breweryDetailFragmentBreweryPostalCodeTv.text = getString(
                R.string.brewery_postal_code, brewery.postalCode
            )
            breweryDetailFragmentBreweryCountryTv.text = getString(
                R.string.brewery_country, brewery.country
            )

            breweryDetailFragmentBreweryPhoneTv.text = getString(
                R.string.brewery_phone, brewery.phone
            )
            breweryDetailFragmentBreweryWebsiteUrlTv.text = getString(
                R.string.brewery_website_url, brewery.websiteUrl
            )
        }
    }

    private fun updateContentVisibility(visibility: Boolean) {
        with(binding) {
            breweryDetailFragmentHeaderLl.isVisible = visibility
            breweryDetailFragmentAddressLl.isVisible = visibility
            breweryDetailFragmentContactLl.isVisible = visibility
        }
    }

    private fun updateLoadingVisibility(visibility: Boolean) {
        binding.breweryDetailLoadingPb.isVisible = visibility
    }

    private fun updateLayoutErrorVisibility(visibility: Boolean) {
        binding.breweryDetailErrorCl.isVisible = visibility
    }
}