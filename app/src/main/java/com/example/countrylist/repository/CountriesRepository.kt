package com.example.countrylist.repository

import com.example.countrylist.apiservice.APIRequest
import com.example.countrylist.apiservice.CountriesService
import com.example.countrylist.model.CountryResponseItem
import com.example.countrylist.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountriesRepository: APIRequest() {

    suspend fun fetchCountriesList(): List<CountryResponseItem> {
        return withContext(Dispatchers.IO) {
            try {
                return@withContext apiRequest { CountriesService().getCountriesData(Constants.ENDPOINT) }
            } catch (e: Exception) {
                throw e
            }
        }
    }

}