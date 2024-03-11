package com.example.walmartcountrylist.apiservice

import com.example.walmartcountrylist.utils.Constants
import com.example.walmartcountrylist.utils.NetworkException
import com.example.walmartcountrylist.utils.NoInternetException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class APIRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {

        val response = try {
            call.invoke()
        } catch (e: Exception) {
            throw NoInternetException(Constants.UNKNOWN_HOST_EXCEPTION)
        }

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) {
                    throw e
                }
                message.append("\n")
            }
            message.append("Error Code :${response.code()}")
            throw NetworkException(message.toString())
        }
    }
}