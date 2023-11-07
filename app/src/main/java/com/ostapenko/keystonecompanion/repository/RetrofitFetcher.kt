package com.ostapenko.keystonecompanion.repository


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
       val selectedRegion = dataStoreManager.getSelectedRegion().first() ?: baseRegion
       // Log.d("REGION", "selected region = ${selectedRegion.name}")
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
        //Log.d(TAG, "$weeklyAffixes, and list $weeklyAffixesList")
    }.flowOn(Dispatchers.IO) // Run the Flow on an IO dispatcher to avoid blocking the main thread

  suspend  fun fetchCutoffsRaiderIoApi(selectedRegion: Region): Flow<List<String>> = flow {
        // Create a Retrofit instance with a Gson converter
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raider.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the API service
        val apiService = retrofit.create(NetworkApi::class.java)

        //season-df-2

        // Make the API call using the suspend function and emit the data as a Flow
        val response = apiService.getSeasonCutoffs(region = selectedRegion.name)
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