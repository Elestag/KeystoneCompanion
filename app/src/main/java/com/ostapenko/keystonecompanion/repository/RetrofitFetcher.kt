package com.ostapenko.keystonecompanion.repository


import android.util.Log
import com.ostapenko.keystonecompanion.model.Region
import com.ostapenko.keystonecompanion.network.api.NetworkApi
import com.ostapenko.keystonecompanion.ui.main.datastore.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//private const val TAG = "retrofit"

class RetrofitFetcher(private val dataStoreManager: DataStoreManager) {
    private val baseRegion = Region.US

   suspend fun fetchDataFromRaiderIoApi(): Flow<List<String>> = flow {
      // Log.d("cutoffs", "fetchDataFromRaiderIoApi called")
       val selectedRegion = dataStoreManager.getSelectedRegion().first() ?: baseRegion
       // Log.d("cutoffs", "selected region = ${selectedRegion.name}")

        // Create a Retrofit instance with a Gson converter
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raider.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the API service
        val apiService = retrofit.create(NetworkApi::class.java)

        // Make the API call using the suspend function and emit the data as a Flow
        val weeklyAffixes = apiService.getWeeklyAffixes(region = selectedRegion.name, locale = "en").title
        val weeklyAffixesList = weeklyAffixes.split(", ").map { (it) }
        emit(weeklyAffixesList)
      //  Log.d("cutoffs", "weekly affixes = $weeklyAffixes, and weeklyAffixesList $weeklyAffixesList")
     //  Log.d("cutoffs", "Thread for affixes = ${Thread.currentThread().name}")
    }.flowOn(Dispatchers.IO) // Run the Flow on an IO dispatcher to avoid blocking the main thread

  suspend  fun fetchCutoffsRaiderIoApi(selectedRegion: Region): Flow<List<String>> = flow {
        // Create a Retrofit instance with a Gson converter
      //Log.d("cutoffs", "fetchCutoffsRaiderIoApi called")
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raider.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the API service
        val apiService = retrofit.create(NetworkApi::class.java)

        //season-df-2

        // Make the API call using the suspend function and emit the data as a Flow
        val response = apiService.getSeasonCutoffs(region = selectedRegion.name)
      //  Log.d("cutoffs", "$response")
        val cutoffs = response.body()
      //  Log.d("cutoffs", "cutoffs from response.body() = $cutoffs")
        val minRating = cutoffs?.pnine?.cutoffs?.all?.quantileMinValue
        val color = cutoffs?.pnine?.cutoffs?.allColor
       // Log.d("cutoffs", "minRating = $minRating, color = $color")
      //  Log.d("cutoffs", "Thread for rating = ${Thread.currentThread().name}")

        emit( listOf(minRating.toString(), color.toString()))
    }.flowOn(Dispatchers.IO) // Run the Flow on an IO dispatcher to avoid blocking the main thread

}