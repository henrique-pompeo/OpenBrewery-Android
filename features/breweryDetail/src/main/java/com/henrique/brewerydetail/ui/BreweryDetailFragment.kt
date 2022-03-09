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
import com.henrique.shared.data.ResultStatus
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
                    is ResultStatus.Loading -> {
                        binding.breweryDetailLoadingPb.visibility = View.VISIBLE
                        binding.breweryDetailFragmentHeaderLl.visibility = View.GONE
                        binding.breweryDetailFragmentAddressLl.visibility = View.GONE
                        binding.breweryDetailFragmentContactLl.visibility = View.GONE
                        binding.breweryDetailErrorCl.visibility  = View.GONE
                    }
                    is ResultStatus.Success -> {
                        it.data.let { brewery ->
                            binding.breweryDetailFragmentBreweryNameTv.text = brewery.name
                            binding.breweryDetailFragmentBreweryTypeTv.text = brewery.breweryType

                            binding.breweryDetailFragmentBreweryStreetTv.text = getString(
                                R.string.brewery_street, brewery.street
                            )
                            binding.breweryDetailFragmentBreweryAddress2Tv.text = getString(
                                R.string.brewery_address2, brewery.address2
                            )
                            binding.breweryDetailFragmentBreweryAddress3Tv.text = getString(
                                R.string.brewery_address3, brewery.address3
                            )
                            binding.breweryDetailFragmentBreweryCityTv.text = getString(
                                R.string.brewery_city, brewery.city
                            )
                            binding.breweryDetailFragmentBreweryStateTv.text = getString(
                                R.string.brewery_state, brewery.state
                            )
                            binding.breweryDetailFragmentBreweryCountyProvinceTv.text = getString(
                                R.string.brewery_county_province, brewery.countyProvince
                            )
                            binding.breweryDetailFragmentBreweryPostalCodeTv.text = getString(
                                R.string.brewery_postal_code, brewery.postalCode
                            )
                            binding.breweryDetailFragmentBreweryCountryTv.text = getString(
                                R.string.brewery_country, brewery.country
                            )

                            binding.breweryDetailFragmentBreweryPhoneTv.text = getString(
                                R.string.brewery_phone, brewery.phone
                            )
                            binding.breweryDetailFragmentBreweryWebsiteUrlTv.text = getString(
                                R.string.brewery_website_url, brewery.websiteUrl
                            )
                        }
                        binding.breweryDetailLoadingPb.visibility = View.GONE
                        binding.breweryDetailFragmentHeaderLl.visibility = View.VISIBLE
                        binding.breweryDetailFragmentAddressLl.visibility = View.VISIBLE
                        binding.breweryDetailFragmentContactLl.visibility = View.VISIBLE
                        binding.breweryDetailErrorCl.visibility  = View.GONE
                    }
                    is ResultStatus.Error -> {
                        binding.breweryDetailLoadingPb.visibility = View.GONE
                        binding.breweryDetailFragmentHeaderLl.visibility = View.GONE
                        binding.breweryDetailFragmentAddressLl.visibility = View.GONE
                        binding.breweryDetailFragmentContactLl.visibility = View.GONE
                        binding.breweryDetailErrorCl.visibility  = View.VISIBLE
                        binding.errorTv.text = it.exception.message
                    }
                }
            })
        }
    }
}