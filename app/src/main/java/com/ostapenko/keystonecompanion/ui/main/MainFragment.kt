package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.FragmentMainBinding
import com.ostapenko.keystonecompanion.ui.base.viewBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding { FragmentMainBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dungeonsButton.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container,DungeonsFragment())?.commit()
        }
    }
}