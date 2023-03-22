package com.ostapenko.keystonecompanion.repository

import android.util.Log
import com.ostapenko.keystonecompanion.network.api.RaiderIoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "retrofit"
class RetrofitFetcher {


    fun fetchDataFromApi(): Flow<List<String>> = flow {
        // Create a Retrofit instance with a Gson converter
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raider.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the API service
        val apiService = retrofit.create(RaiderIoApi::class.java)

        // Make the API call using the suspend function and emit the data as a Flow
        val weeklyAffixes = apiService.getWeeklyAffixes().title
        val weeklyAffixesList = weeklyAffixes.split(", ").map { (it) }
        emit(weeklyAffixesList)
        Log.d(TAG,"$weeklyAffixes, and list $weeklyAffixesList")
    }.flowOn(Dispatchers.IO) // Run the Flow on an IO dispatcher to avoid blocking the main thread
}