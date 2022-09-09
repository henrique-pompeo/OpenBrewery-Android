package com.henrique.openbrewery.features.brewerydetail.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.henrique.brewerydetail.R
import com.henrique.brewerydetail.databinding.BreweryDetailFragmentBinding
import com.henrique.openbrewery.features.brewerydetail.presentation.viewmodel.BreweryDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetailState
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail
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
                    is BreweryDetailState.Loading -> showLoading()
                    is BreweryDetailState.Success -> showContent(it.data)
                    is BreweryDetailState.Error -> showLayoutError(it.message)
                }
            })
        }
    }

    private fun showLoading() {
        updateLoadingVisibility(true)
        updateContentVisibility(false)
        updateLayoutErrorVisibility(false)
    }

    private fun showContent(brewery: BreweryDetail) {
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

    private fun updateFields(brewery: BreweryDetail) {
        with(binding) {
            breweryDetailFragmentBreweryNameTv.text = brewery.name
            breweryDetailFragmentBreweryTypeTv.text = brewery.breweryType
            updateBreweryTypeDescription()
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

    private fun updateBreweryTypeDescription() {
        with(binding) {
            breweryDetailFragmentBreweryTypeDescTv.text =
                breweryDetailFragmentBreweryTypeTv.text.let {
                    when (it) {
                        "micro" -> getString(R.string.brewery_type_micro_desc)
                        "nano" -> getString(R.string.brewery_type_nano_desc)
                        "regional" -> getString(R.string.brewery_type_regional_desc)
                        "brewpub" -> getString(R.string.brewery_type_brewpub_desc)
                        "large" -> getString(R.string.brewery_type_large_desc)
                        "planning" -> getString(R.string.brewery_type_planning_desc)
                        "bar" -> getString(R.string.brewery_type_bar_desc)
                        "contract" -> getString(R.string.brewery_type_contract_desc)
                        "proprietor" -> getString(R.string.brewery_type_proprietor_desc)
                        "closed" -> getString(R.string.brewery_type_closed_desc)
                        else -> "No type found"
                    }
                }
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