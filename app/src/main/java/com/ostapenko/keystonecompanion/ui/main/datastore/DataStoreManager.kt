package com.ostapenko.keystonecompanion.ui.main.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ostapenko.keystonecompanion.model.Region
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "region_prefs")

class DataStoreManager(context: Context) {
    private val dataStore = context.dataStore

    val selectedRegion: Flow<Region?> = dataStore.data.map { preferences ->
        val regionName = preferences[PreferencesKeys.SELECTED_REGION]
        regionName?.let { Region.valueOf(it) }
    }

    suspend fun saveSelectedRegion(region: Region) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SELECTED_REGION] = region.name
        }
    }

    private object PreferencesKeys {
        val SELECTED_REGION = stringPreferencesKey("selected_region")
    }
}