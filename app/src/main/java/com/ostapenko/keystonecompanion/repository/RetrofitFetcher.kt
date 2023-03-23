package com.ostapenko.keystonecompanion.repository

import android.util.Log
import com.ostapenko.keystonecompanion.network.api.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val TAG = "retrofit"

class RetrofitFetcher {


    fun fetchDataFromRaiderIoApi(): Flow<List<String>> = flow {
        // Create a Retrofit instance with a Gson converter
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raider.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the API service
        val apiService = retrofit.create(NetworkApi::class.java)

        // Make the API call using the suspend function and emit the data as a Flow
        val weeklyAffixes = apiService.getWeeklyAffixes().title
        val weeklyAffixesList = weeklyAffixes.split(", ").map { (it) }
        emit(weeklyAffixesList)
        //Log.d(TAG, "$weeklyAffixes, and list $weeklyAffixesList")
    }.flowOn(Dispatchers.IO) // Run the Flow on an IO dispatcher to avoid blocking the main thread


    fun fetchDataFromBlizzardApi(): Flow<String> = flow<String> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://eu.api.blizzard.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(NetworkApi::class.java)

        val tokenPriceRaw = apiService.getTokenPrice().tokenPrice

        val tokenPrice = tokenPriceRaw.subSequence(0, 3).toString() + "," + tokenPriceRaw.subSequence(3,6).toString()
      //  Log.d(TAG, "$tokenPriceRaw, and subsequence $tokenPrice")
        emit(tokenPrice)
    }.flowOn(Dispatchers.IO)
}