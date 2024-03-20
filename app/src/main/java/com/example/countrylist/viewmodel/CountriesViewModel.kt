package com.example.countrylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrylist.model.CountryResponseItem
import androidx.lifecycle.viewModelScope
import com.example.countrylist.repository.CountriesRepository
import com.example.countrylist.utils.NoInternetException
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers

class CountriesViewModel(
    private val repository: CountriesRepository
) : ViewModel() {

    private val _countriesData: MutableLiveData<List<CountryResponseItem>> = MutableLiveData<List<CountryResponseItem>>()
    val countriesData: LiveData<List<CountryResponseItem>>
        get() = _countriesData

    fun fetchCountriesData() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                _countriesData.value = repository.fetchCountriesList()
            } catch (e: NoInternetException) {
                e.printStackTrace()
                _countriesData.value = listOf() // This helps in updating progressbar/emptyText state on UI as data set has size = 0 since an exception has occurred
            } catch (e: Exception) { // This will catch all the other categories of exceptions: JSONException/NetworkException/Exception
                e.printStackTrace()
                _countriesData.value = listOf() // For the sake of simplicity I am only updating progressbar/emptyText state on UI as data set size = 0 since an exception has occurred
            }
        }
    }

}