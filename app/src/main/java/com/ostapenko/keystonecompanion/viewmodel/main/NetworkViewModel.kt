package com.ostapenko.keystonecompanion.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ostapenko.keystonecompanion.repository.RetrofitFetcher
import com.ostapenko.keystonecompanion.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NetworkViewModel : BaseViewModel() {

    private var retrofitFetcher: RetrofitFetcher = RetrofitFetcher()

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