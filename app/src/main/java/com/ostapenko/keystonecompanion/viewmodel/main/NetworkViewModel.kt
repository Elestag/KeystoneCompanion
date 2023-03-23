package com.ostapenko.keystonecompanion.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ostapenko.keystonecompanion.repository.RetrofitFetcher
import com.ostapenko.keystonecompanion.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NetworkViewModel : BaseViewModel() {

    private var retrofitFetcher: RetrofitFetcher = RetrofitFetcher()

    private val _tokenPrice = MutableLiveData<String>()
    val tokenPrice: LiveData<String> = _tokenPrice

    private val _myData = MutableLiveData<List<String>>()
    val myData: LiveData<List<String>> = _myData

    // Launch a coroutine scope to fetch the data
    init {
        viewModelScope.launch(Dispatchers.IO) {
            retrofitFetcher.fetchDataFromRaiderIoApi().collect { data ->
                _myData.postValue(data)
            }
            retrofitFetcher.fetchDataFromBlizzardApi().collect { data ->
                _tokenPrice.postValue(data)
            }

        }
    }

}