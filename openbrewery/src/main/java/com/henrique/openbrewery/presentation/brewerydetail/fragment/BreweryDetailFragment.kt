package com.henrique.openbrewery.presentation.brewerydetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.henrique.openbrewery.R
import com.henrique.openbrewery.databinding.BreweryDetailFragmentBinding
import com.henrique.openbrewery.domain.brewery.model.BreweryType
import com.henrique.openbrewery.domain.brewerydetail.mappers.BreweryDetailItemMapper
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailItem
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState
import com.henrique.openbrewery.presentation.brewerydetail.viewmodel.BreweryDetailViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreweryDetailFragment : Fragment() {

    private var binding: BreweryDetailFragmentBinding? = null
    private val viewModel: BreweryDetailViewModel by viewModel()
    private val breweryDetailItemMapper: BreweryDetailItemMapper by inject()
    private val navArgs: BreweryDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = BreweryDetailFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
        getBreweryDetails(navArgs.id)
    }

    private fun setupListeners() {
        binding?.retryBt?.setOnClickListener {
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
        binding?.run {
            breweryDetailItem.name?.let {
                breweryDetailBreweryNameText.text = it
                breweryDetailBreweryNameText.isVisible = true
            }
            breweryDetailItem.breweryType?.let {
                breweryDetailBreweryTypeText.text = it
                breweryDetailBreweryTypeText.isVisible = true
            }
            updateBreweryTypeDescription()
            val address = getAddressText(
                breweryDetailItem.address2 + breweryDetailItem.address3
            )
            address.takeUnless { address.isNullOrEmpty() }?.let {
                breweryDetailAddressText.text = getString(R.string.brewery_address, it)
                breweryDetailAddressText.isVisible = true
            }
            breweryDetailItem.street?.let {
                breweryDetailStreetText.text = getString(R.string.brewery_street, it)
                breweryDetailStreetText.isVisible = true
            }
            breweryDetailItem.postalCode?.let {
                breweryDetailPostalCodeText.text = getString(R.string.brewery_postal_code, it)
                breweryDetailPostalCodeText.isVisible = true
            }
            val city = getCityText(breweryDetailItem.city + breweryDetailItem.state)
            city.takeUnless { city.isNullOrEmpty() }?.let {
                breweryDetailCityText.text = getString(
                    R.string.brewery_city, breweryDetailItem.city, breweryDetailItem.state
                )
                breweryDetailCityText.isVisible = true
            }
            breweryDetailItem.country?.let {
                breweryDetailCountryText.text = getString(R.string.brewery_country, it)
                breweryDetailCountryText.isVisible = true
            }
            breweryDetailItem.phone?.let {
                breweryDetailPhoneText.text = getString(R.string.brewery_phone, it)
                breweryDetailPhoneText.isVisible = true
            }
            breweryDetailItem.websiteUrl?.let {
                breweryDetailWebsiteText.text = getString(R.string.brewery_website_url, it)
                breweryDetailWebsiteText.isVisible = true
            }
        }
    }

    private fun getAddressText(address: String?) : String? =
        address?.replace("null", "")?.trim()

    private fun getCityText(city: String?) : String? =
        city?.replace("null", "")?.trim()

    private fun updateBreweryTypeDescription() {
        binding?.run {
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

    private fun reloadBreweryDetails() = getBreweryDetails(navArgs.id)

    private fun getBreweryDetails(id: String) = viewModel.getBreweryDetails(id = id)

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
        binding?.breweryDetailLoadingPb?.isVisible = visibility
    }

    private fun showError(visibility: Boolean) {
        binding?.breweryDetailErrorCl?.isVisible = visibility
    }
}
