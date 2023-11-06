package com.ostapenko.keystonecompanion.ui

import android.app.Application
import com.ostapenko.keystonecompanion.ui.main.datastore.DataStoreManager

class KeystoneApplication : Application() {
    lateinit var dataStoreManager: DataStoreManager

    override fun onCreate() {
        super.onCreate()
        dataStoreManager = DataStoreManager(this)
    }
}