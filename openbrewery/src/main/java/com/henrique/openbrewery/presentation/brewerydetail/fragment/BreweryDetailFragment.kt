package com.henrique.openbrewery.presentation.brewerydetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.henrique.openbrewery.R
import com.henrique.openbrewery.databinding.BreweryDetailFragmentBinding
import com.henrique.openbrewery.domain.brewery.model.BreweryType
import com.henrique.openbrewery.domain.brewerydetail.mappers.BreweryDetailItemMapper
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailItem
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState
import com.henrique.openbrewery.presentation.brewerydetail.viewmodel.BreweryDetailViewModel
import com.henrique.openbrewery.presentation.brewerylist.viewmodel.BreweryListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreweryDetailFragment : Fragment() {

    private lateinit var binding: BreweryDetailFragmentBinding
    private val breweryListViewModel: BreweryListViewModel by sharedViewModel()
    private val viewModel: BreweryDetailViewModel by viewModel()
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
        activity?.onBackPressedDispatcher?.addCallback(
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack(R.id.breweryDetailFragment, true)
                }
            }
        )
    }

    private fun setupObservers() {
        with (breweryListViewModel) {
            clickedBrewery.observe(viewLifecycleOwner) {
                it?.let {
                    getBreweryDetails(it)
                    breweryListViewModel.clearStates()
                }
            }
        }
        with (viewModel) {
            breweryDetailState.observe(viewLifecycleOwner) {
                when (it) {
                    is BreweryDetailState.Loading -> updateScreen(showLoading = true)
                    is BreweryDetailState.Success -> updateScreen(
                            breweryDetailItem = breweryDetailItemMapper.toItem(it.breweryDetail)
                    )
                    is BreweryDetailState.Error -> updateScreen(showError = true)
                }
            }
        }
    }

    private fun updateFields(breweryDetailItem: BreweryDetailItem) {
        with(binding) {
            breweryDetailBreweryNameText.text = breweryDetailItem.name
            breweryDetailBreweryTypeText.text = breweryDetailItem.breweryType
            updateBreweryTypeDescription()
            breweryDetailAddressText.text = getString(
                R.string.brewery_address,
                breweryDetailItem.address2 + breweryDetailItem.address3
            )
            breweryDetailStreetText.text = getString(
                R.string.brewery_street, breweryDetailItem.street
            )
            breweryDetailPostalCodeText.text = getString(
                R.string.brewery_postal_code, breweryDetailItem.postalCode
            )
            breweryDetailCityText.text = getString(
                R.string.brewery_city, breweryDetailItem.city, breweryDetailItem.state
            )
            breweryDetailCountryText.text = getString(
                R.string.brewery_country, breweryDetailItem.country
            )
            breweryDetailPhoneText.text = getString(
                R.string.brewery_phone, breweryDetailItem.phone
            )
            breweryDetailWebsiteText.text = getString(
                R.string.brewery_website_url, breweryDetailItem.websiteUrl
            )
        }
    }

    private fun updateBreweryTypeDescription() {
        with(binding) {
            breweryDetailFragmentBreweryTypeDescTv.text =
                breweryDetailBreweryTypeText.text.let {
                    when (it) {
                        BreweryType.MICRO.value -> getString(R.string.brewery_type_micro_desc)
                        BreweryType.NANO.value -> getString(R.string.brewery_type_nano_desc)
                        BreweryType.REGIONAL.value -> getString(R.string.brewery_type_regional_desc)
                        BreweryType.BREWPUB.value -> getString(R.string.brewery_type_brewpub_desc)
                        BreweryType.LARGE.value -> getString(R.string.brewery_type_large_desc)
                        BreweryType.PLANNING.value -> getString(R.string.brewery_type_planning_desc)
                        BreweryType.BAR.value -> getString(R.string.brewery_type_bar_desc)
                        BreweryType.CONTRACT.value -> getString(R.string.brewery_type_contract_desc)
                        BreweryType.PROPRIETOR.value -> getString(R.string.brewery_type_proprietor_desc)
                        BreweryType.CLOSED.value -> getString(R.string.brewery_type_closed_desc)
                        else -> getString(R.string.brewery_type_not_found)
                    }
                }
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
        showLoading: Boolean = false,
        breweryDetailItem: BreweryDetailItem? = null,
        showError: Boolean = false
    ) {
        showLoading(showLoading)
        breweryDetailItem?.let { updateFields(it) }
        showError(showError)
    }

    private fun showLoading(visibility: Boolean) {
        binding.breweryDetailLoadingPb.isVisible = visibility
    }

    private fun showError(visibility: Boolean) {
        binding.breweryDetailErrorCl.isVisible = visibility
    }
}