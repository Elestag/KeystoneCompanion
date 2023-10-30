package com.ostapenko.keystonecompanion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ActivityMainBinding
import com.ostapenko.keystonecompanion.ui.main.DetailedDungeonFragment
import com.ostapenko.keystonecompanion.ui.main.DungeonsFragment
import com.ostapenko.keystonecompanion.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, DetailedDungeonFragment())
                .commitAllowingStateLoss()
        }
    }
}