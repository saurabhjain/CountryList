package com.example.walmartcountrylist.utils

import java.io.IOException

class NetworkException(message : String) : IOException(message)
class NoInternetException (message: String) : IOException(message)