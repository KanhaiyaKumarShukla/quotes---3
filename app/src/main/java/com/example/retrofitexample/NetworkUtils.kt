package com.example.retrofitexample

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

// refer to EarthQuakeReport-2 / MainActivity.kt
class NetworkUtils {

    companion object{
        fun isInternetAvailable(context: Context):Boolean{
            val connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                val network=connectivityManager.activeNetwork
                if(network!=null) {
                    val capabilities = connectivityManager.getNetworkCapabilities(network)
                    if (capabilities != null) {
                        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    }
                }
            }else{
                return connectivityManager.activeNetworkInfo?.isConnected?:false
            }
            return false
        }
    }
}