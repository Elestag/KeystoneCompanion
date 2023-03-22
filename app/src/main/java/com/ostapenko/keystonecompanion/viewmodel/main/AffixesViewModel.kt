package com.ostapenko.keystonecompanion.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ostapenko.keystonecompanion.repository.RetrofitFetcher
import com.ostapenko.keystonecompanion.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AffixesViewModel : BaseViewModel() {

    private var retrofitFetcher: RetrofitFetcher = RetrofitFetcher()
    private val _myData = MutableLiveData<List<String>>()
    val myData: LiveData<List<String>> = _myData

    // Launch a coroutine scope to fetch the data
    init {
        viewModelScope.launch(Dispatchers.IO) {
            retrofitFetcher.fetchDataFromApi().collect { data ->
                _myData.postValue(data)

            }
        }
    }

}