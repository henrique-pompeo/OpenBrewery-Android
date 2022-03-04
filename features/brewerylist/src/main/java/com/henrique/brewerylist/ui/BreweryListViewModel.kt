package com.henrique.brewerylist.ui

import androidx.lifecycle.MutableLiveData
import com.henrique.shared.ui.base.BaseViewModel
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.shared.domain.model.Brewery
import com.henrique.shared.data.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListViewModel(private val breweryListRepository: BreweryListRepository) : BaseViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val breweryList = MutableLiveData<Result<List<Brewery>>>()

    fun getBreweryList() {
        breweryList.value = Result.Loading
        viewModelScope.launch {
            try {
                // TODO -- IF THE FUNCTION RETURNS TRUE FOR INTERNET CONECTION
                //  SHOULD LOAD ALL ITEMS FROM SERVICE THEN DOWNLOAD AND SAVE AT ROOM DATABASE
                //  IF IT RETURNS FALSE
                //      SHOULD LOAD ITEMS FROM ROOM DATABASE
                //  FOR BOTH CASES, IF ANY ERROR HAPPENS, SHOULD SHOW THE ERROR PAGE
                //  AND IF IT DOESN'T RETURN ANYTHING SHOULD SHOW THE EMPTY PAGE (ITEMS == 0)
                breweryList.value = Result.Success(breweryListRepository.getBreweryList())
            } catch (e: Exception) {
                breweryList.value = Result.Error(e)
            }
        }
    }




// TODO --- FUNCTION TO VERIFY IF IT HAS INTERNET CONNECTION OR NOT
}