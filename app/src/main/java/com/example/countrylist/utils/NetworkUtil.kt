package com.example.countrylist.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun isNetworkAvailable(context: Context): Boolean {
    var result = false
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    connectivityManager.let {
        it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
            result = when {
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        }
    }
    return result
}