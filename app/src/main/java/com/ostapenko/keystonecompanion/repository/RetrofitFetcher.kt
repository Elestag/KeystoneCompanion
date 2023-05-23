package com.ostapenko.keystonecompanion.repository


import com.ostapenko.keystonecompanion.network.api.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//private const val TAG = "retrofit"

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

    fun fetchCutoffsRaiderIoApi(): Flow<List<String>> = flow {
        // Create a Retrofit instance with a Gson converter
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raider.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the API service
        val apiService = retrofit.create(NetworkApi::class.java)

        //season-df-2

        // Make the API call using the suspend function and emit the data as a Flow
        val response = apiService.getSeasonCutoffs()
        //Log.d(TAG, "$response")
        val cutoffs = response.body()
       // Log.d(TAG, "cutoffsMin = $cutoffs")
        val minRating = cutoffs?.pnine?.cutoffs?.all?.quantileMinValue
        val color = cutoffs?.pnine?.cutoffs?.allColor
        //Log.d(TAG, "minRating = $minRating, color = $color")

        emit( listOf(minRating.toString(), color.toString()))
        //Log.d(TAG, "$weeklyAffixes, and list $weeklyAffixesList")
    }.flowOn(Dispatchers.IO) // Run the Flow on an IO dispatcher to avoid blocking the main thread

}