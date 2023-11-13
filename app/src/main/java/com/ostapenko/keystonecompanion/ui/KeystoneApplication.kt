package com.ostapenko.keystonecompanion.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.ostapenko.keystonecompanion.ui.main.datastore.DataStoreManager

class KeystoneApplication : Application() {
    val dataStoreManager: DataStoreManager by lazy { DataStoreManager(this) }
    val connectivityManager: ConnectivityManager by lazy {
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

}