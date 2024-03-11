package com.example.walmartcountrylist.apiservice

import com.example.walmartcountrylist.BuildConfig
import com.example.walmartcountrylist.model.CountryResponseItem
import com.example.walmartcountrylist.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

interface CountriesService {

    @GET
    suspend fun getCountriesData(@Url url: String): Response<List<CountryResponseItem>>

    companion object {

        operator fun invoke(): CountriesService {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(logInterceptor)
                .build()
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(CountriesService::class.java)
        }
    }

}