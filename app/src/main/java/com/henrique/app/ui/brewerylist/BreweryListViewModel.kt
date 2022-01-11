package com.henrique.app.ui.brewerylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.post.domain.usecase.base.UseCaseResponse
import com.henrique.domain.model.Brewery
import com.henrique.domain.usecases.GetBreweriesUseCase
import kotlinx.coroutines.cancel
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import java.lang.Exception

@KoinApiExtension
class BreweryListViewModel constructor(private val getBreweriesUseCase: GetBreweriesUseCase) :
    ViewModel(), KoinComponent {

    val breweriesData = MutableLiveData<List<Brewery>>()
    val showLoading = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getBreweries() {

        showLoading.value = true
        getBreweriesUseCase.invoke(viewModelScope, null, object :
            UseCaseResponse<List<Brewery>> {

                override fun onSuccess(result: List<Brewery>) {
                    breweriesData.value = result
                    showLoading.value = false
                }

                override fun onError(apiError: Exception) {
                    messageData.value = apiError.message
                    showLoading.value = false
                }
            },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

}