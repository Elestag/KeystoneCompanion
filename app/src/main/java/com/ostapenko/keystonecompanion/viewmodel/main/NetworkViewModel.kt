package com.ostapenko.keystonecompanion.viewmodel.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ostapenko.keystonecompanion.model.Region
import com.ostapenko.keystonecompanion.repository.RetrofitFetcher
import com.ostapenko.keystonecompanion.ui.main.datastore.DataStoreManager
import com.ostapenko.keystonecompanion.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class NetworkViewModel(
    private val dataStoreManager: DataStoreManager,
) : BaseViewModel() {
    private var retrofitFetcher: RetrofitFetcher = RetrofitFetcher(dataStoreManager)

    private val _affixes = MutableStateFlow<List<String>>(emptyList())
    val affixes: StateFlow<List<String>> = _affixes

    private val _rating = MutableStateFlow<List<String>>(emptyList())
    val rating: StateFlow<List<String>> = _rating

    // Initialize data fetching in the constructor
    init {
         //   Log.d("cutoffs", "NetworkViewModel initialized")
            fetchData()
    }

    // Function to set the selected region and update rating data
    fun setRegion(selectedRegion: Region) {
        viewModelScope.launch(Dispatchers.IO) {
            // Update the rating data based on the selected region
            /*  val newRatingData =
                  retrofitFetcher.fetchCutoffsRaiderIoApi(selectedRegion).toList().flatten()
              _rating.value = newRatingData*/

            retrofitFetcher.fetchCutoffsRaiderIoApi(selectedRegion).collect { ratingData ->
                _rating.value = ratingData
            }
        }
    }

    // Function to fetch data for the initially selected region
    private fun fetchData() {
       // Log.d("cutoffs", "fetchData being CALLED")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("cutoffs", "Thread for fetchData = ${Thread.currentThread().name}")
            val initiallySelectedRegion = dataStoreManager.getSelectedRegion().first()
            Log.d("cutoffs", "InitiallySelectedRegion = $initiallySelectedRegion")
            if (initiallySelectedRegion != null) {
                setRegion(initiallySelectedRegion)
            }else{
                setRegion(Region.US)
            }

            retrofitFetcher.fetchDataFromRaiderIoApi().collect { affixesData ->
                _affixes.value = affixesData
            }
        }
    }

}

class NetworkViewModelFactory(
    private val dataStoreManager: DataStoreManager,
) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NetworkViewModel::class.java)) {
            return NetworkViewModel(dataStoreManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
