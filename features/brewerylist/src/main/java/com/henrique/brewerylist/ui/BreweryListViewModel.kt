package com.henrique.brewerylist.ui

import androidx.lifecycle.MutableLiveData
import com.henrique.shared.ui.base.BaseViewModel
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.shared.domain.model.Brewery
import com.henrique.shared.data.Result
import com.henrique.shared.data.database.entities.BreweryEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListViewModel(private val breweryListRepository: BreweryListRepository) : BaseViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val breweryListLiveData = MutableLiveData<Result<List<Brewery>>>()

    fun getBreweryList() {
        breweryListLiveData.value = Result.Loading
        viewModelScope.launch {
            try {
                breweryListLiveData.value = Result.Success(breweryListRepository.getBreweryList())
            } catch (e: Exception) {
                try {
                    breweryListLiveData.value = Result.Success(breweryListRepository.getBreweryListLocal())
                } catch (localEx: Exception) {
                    breweryListLiveData.value = Result.Error(localEx)
                }
            }
        }
    }

    fun updateDatabase(breweryList: List<Brewery>) {
        breweryList.forEach {
            viewModelScope.launch {
                try {
                    breweryListRepository.insertBrewery(
                        BreweryEntity(
                            id = it.id,
                            name = it.name,
                            breweryType = it.breweryType,
                            street = it.street,
                            address2 = it.address2,
                            address3 = it.address3,
                            city = it.city,
                            state = it.state,
                            countyProvince = it.countyProvince,
                            postalCode = it.postalCode,
                            country = it.country,
                            longitude = it.longitude,
                            latitude = it.latitude,
                            phone = it.phone,
                            websiteUrl = it.websiteUrl,
                            updatedAt = it.updatedAt,
                            createdAt = it.createdAt
                        )
                    )
                } catch (e: Exception) {
                    breweryListLiveData.value = Result.Error(e)
                }
            }
        }
    }
}