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

    private val _myData = MutableLiveData<List<String>>()
    val myData: LiveData<List<String>> = _myData

    private val _rating = MutableLiveData<List<String>>()
    val rating: LiveData<List<String>> = _rating

    // Launch a coroutine scope to fetch the data
    init {
        viewModelScope.launch(Dispatchers.IO) {
            retrofitFetcher.fetchDataFromRaiderIoApi().collect { data ->
                _myData.postValue(data)
            }

            viewModelScope.launch(Dispatchers.IO) {
                retrofitFetcher.fetchCutoffsRaiderIoApi().collect { data ->
                    _rating.postValue(data)
                }
            }


        }
    }

}