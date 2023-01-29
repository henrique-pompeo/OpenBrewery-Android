package com.henrique.openbrewery.presentation.brewerydetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.henrique.openbrewery.R
import com.henrique.openbrewery.databinding.BreweryDetailFragmentBinding
import com.henrique.openbrewery.domain.brewerydetail.mappers.BreweryDetailItemMapper
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailItem
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState
import com.henrique.openbrewery.presentation.brewerydetail.viewmodel.BreweryDetailViewModel
import com.henrique.openbrewery.presentation.brewerylist.viewmodel.BreweryListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.navigation.koinNavGraphViewModel

class BreweryDetailFragment : Fragment() {

    private lateinit var binding: BreweryDetailFragmentBinding
    private val breweryListViewModel: BreweryListViewModel by koinNavGraphViewModel(R.id.openbrewery_navigation)
    private val viewModel: BreweryDetailViewModel by inject()
    private val breweryDetailItemMapper: BreweryDetailItemMapper by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = BreweryDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
        binding.retryBt.setOnClickListener {
            reloadBreweryDetails()
        }
    }

    private fun setupObservers() {
        with (breweryListViewModel) {
            clickedBrewery.observe(viewLifecycleOwner) {
                getBreweryDetails(it)
            }
        }
        with (viewModel) {
            breweryDetailState.observe(viewLifecycleOwner) {
                when (it) {
                    is BreweryDetailState.Loading ->
                        updateScreen(
                            showLoading = true,
                            breweryDetailItem = null,
                            showError = false
                        )
                    is BreweryDetailState.Success ->
                        updateScreen(
                            showLoading = false,
                            breweryDetailItem = breweryDetailItemMapper.toItem(it.breweryDetail),
                            showError = false
                        )
                    is BreweryDetailState.Error ->
                        updateScreen(
                            showLoading = false,
                            breweryDetailItem = null,
                            showError = true
                        )
                }
            }
        }
    }

    private fun updateFields(breweryDetailItem: BreweryDetailItem) {
        with(binding) {
//            breweryDetailFragmentBreweryNameTv.text = breweryDetailItem.name
//            breweryDetailFragmentBreweryTypeTv.text = breweryDetailItem.breweryType
//            updateBreweryTypeDescription()
//            breweryDetailFragmentBreweryStreetTv.text = getString(
//                R.string.brewery_street, breweryDetailItem.street
//            )
//            breweryDetailFragmentBreweryAddress2Tv.text = getString(
//                R.string.brewery_address2, breweryDetailItem.address2
//            )
//            breweryDetailFragmentBreweryAddress3Tv.text = getString(
//                R.string.brewery_address3, breweryDetailItem.address3
//            )
//            breweryDetailFragmentBreweryCityTv.text = getString(
//                R.string.brewery_city, breweryDetailItem.city
//            )
//            breweryDetailFragmentBreweryStateTv.text = getString(
//                R.string.brewery_state, breweryDetailItem.state
//            )
//            breweryDetailFragmentBreweryCountyProvinceTv.text = getString(
//                R.string.brewery_county_province, breweryDetailItem.countyProvince
//            )
//            breweryDetailFragmentBreweryPostalCodeTv.text = getString(
//                R.string.brewery_postal_code, breweryDetailItem.postalCode
//            )
//            breweryDetailFragmentBreweryCountryTv.text = getString(
//                R.string.brewery_country, breweryDetailItem.country
//            )
//
//            breweryDetailFragmentBreweryPhoneTv.text = getString(
//                R.string.brewery_phone, breweryDetailItem.phone
//            )
//            breweryDetailFragmentBreweryWebsiteUrlTv.text = getString(
//                R.string.brewery_website_url, breweryDetailItem.websiteUrl
//            )
        }
    }

    private fun updateBreweryTypeDescription() {
        with(binding) {
//            breweryDetailFragmentBreweryTypeDescTv.text =
//                breweryDetailFragmentBreweryTypeTv.text.let {
//                    when (it) {
//                        "micro" -> getString(R.string.brewery_type_micro_desc)
//                        "nano" -> getString(R.string.brewery_type_nano_desc)
//                        "regional" -> getString(R.string.brewery_type_regional_desc)
//                        "brewpub" -> getString(R.string.brewery_type_brewpub_desc)
//                        "large" -> getString(R.string.brewery_type_large_desc)
//                        "planning" -> getString(R.string.brewery_type_planning_desc)
//                        "bar" -> getString(R.string.brewery_type_bar_desc)
//                        "contract" -> getString(R.string.brewery_type_contract_desc)
//                        "proprietor" -> getString(R.string.brewery_type_proprietor_desc)
//                        "closed" -> getString(R.string.brewery_type_closed_desc)
//                        else -> "No type found"
//                    }
//                }
        }
    }

    private fun reloadBreweryDetails() {
        breweryListViewModel.clickedBrewery.value?.let {
            getBreweryDetails(it)
        }
    }

    private fun getBreweryDetails(id: String) {
        viewModel.getBreweryDetails(id = id)
    }

    private fun updateScreen(
        showLoading: Boolean,
        breweryDetailItem: BreweryDetailItem?,
        showError: Boolean
    ) {
        showLoading(showLoading)
        breweryDetailItem?.let { updateFields(it) }
        showContent(breweryDetailItem != null)
        showError(showError)
    }

    private fun showContent(visibility: Boolean) {
        with(binding) {
//            breweryDetailFragmentHeaderLl.isVisible = visibility
//            breweryDetailFragmentAddressLl.isVisible = visibility
//            breweryDetailFragmentContactLl.isVisible = visibility
        }
    }

    private fun showLoading(visibility: Boolean) {
        binding.breweryDetailLoadingPb.isVisible = visibility
    }

    private fun showError(visibility: Boolean) {
        binding.breweryDetailErrorCl.isVisible = visibility
    }
}