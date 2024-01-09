package com.ostapenko.keystonecompanion.viewmodel.main

import android.net.ConnectivityManager
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
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class NetworkViewModel(
    private val dataStoreManager: DataStoreManager,
    private val connectivityManager: ConnectivityManager
) : BaseViewModel() {
    private var retrofitFetcher: RetrofitFetcher = RetrofitFetcher(dataStoreManager)

    private val _affixes = MutableStateFlow<List<String>>(emptyList())
    val affixes: StateFlow<List<String>> = _affixes

    private val _rating = MutableStateFlow<List<String>>(emptyList())
    val rating: StateFlow<List<String>> = _rating

    private val _isNetworkAvailable = MutableStateFlow(true)
    val isNetworkAvailable: StateFlow<Boolean> = _isNetworkAvailable

    // Function to set the selected region and update rating data
    fun setRegion(selectedRegion: Region) {
        viewModelScope.launch(Dispatchers.IO) {
            // Update the rating data based on the selected region
            if (isNetworkConnected()) {
                val newRatingData =
                    retrofitFetcher.fetchCutoffsRaiderIoApi(selectedRegion).toList().flatten()
                _rating.value = newRatingData
            } else {
                _isNetworkAvailable.value = false
            }
        }
    }

    // Initialize data fetching in the constructor
    init {
        fetchData()
    }

    // Function to fetch data for the initially selected region
    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (isNetworkConnected()) {
                val initiallySelectedRegion = dataStoreManager.getSelectedRegion().first()
                if (initiallySelectedRegion != null) {
                    setRegion(initiallySelectedRegion)
                }
                retrofitFetcher.fetchDataFromRaiderIoApi().collect { data ->
                    _affixes.value = data
                }
            } else {
                _isNetworkAvailable.value = false
            }
        }


    }

    private fun isNetworkConnected(): Boolean {
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}

class NetworkViewModelFactory(
    private val dataStoreManager: DataStoreManager,
    private val connectivityManager: ConnectivityManager
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NetworkViewModel::class.java)) {
            return NetworkViewModel(dataStoreManager, connectivityManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
