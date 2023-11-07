package com.ostapenko.keystonecompanion.viewmodel.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ostapenko.keystonecompanion.repository.RetrofitFetcher
import com.ostapenko.keystonecompanion.ui.main.datastore.DataStoreManager
import com.ostapenko.keystonecompanion.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NetworkViewModel(dataStoreManager: DataStoreManager) : BaseViewModel() {

    private var retrofitFetcher: RetrofitFetcher = RetrofitFetcher(dataStoreManager)

    private val _affixes = MutableStateFlow<List<String>>(emptyList())
    val affixes: StateFlow<List<String>> = _affixes

    private val _rating = MutableStateFlow<List<String>>(emptyList())
    val rating: StateFlow<List<String>> = _rating

    // Launch a coroutine scope to fetch the data
    init {
        viewModelScope.launch(Dispatchers.IO) {
            retrofitFetcher.fetchDataFromRaiderIoApi().collect { data ->
                _affixes.value = data
            }

            viewModelScope.launch(Dispatchers.IO) {
                retrofitFetcher.fetchCutoffsRaiderIoApi().collect { data ->
                    _rating.value = data
                }
            }


        }
    }

}

class NetworkViewModelFactory(private val dataStoreManager: DataStoreManager) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NetworkViewModel::class.java)) {
            return NetworkViewModel(dataStoreManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}