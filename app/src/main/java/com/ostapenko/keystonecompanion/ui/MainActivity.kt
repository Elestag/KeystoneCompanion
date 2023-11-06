package com.ostapenko.keystonecompanion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ActivityMainBinding
import com.ostapenko.keystonecompanion.ui.main.DetailedDungeonFragment
import com.ostapenko.keystonecompanion.ui.main.DungeonsFragment
import com.ostapenko.keystonecompanion.ui.main.MainFragment
import com.ostapenko.keystonecompanion.ui.main.datastore.DataStoreManager

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


    }

    override fun onBackPressed() {
        if (!navController.navigateUp()) {
            super.onBackPressed()
        }

    }
}