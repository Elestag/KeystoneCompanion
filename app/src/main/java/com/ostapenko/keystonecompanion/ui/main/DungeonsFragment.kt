package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonsRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.DungeonsItemRV
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.ui.main.adapters.DungeonsItemAdapter

class DungeonsFragment : Fragment(R.layout.item_dungeons_rv) {

    private val binding by viewBinding { ItemDungeonsRvBinding.bind(it) }
    private val myAdapter = DungeonsItemAdapter(listOf(DungeonsItemRV("Pussy",R.drawable.creature_leymor),
        DungeonsItemRV("Some dung",R.drawable.the_azure_vault_small),
        DungeonsItemRV("Pussy",R.drawable.creature_leymor),
        DungeonsItemRV("Some dung",R.drawable.the_azure_vault_small),
    ))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dungeonsRecyclerView.apply {
            adapter = myAdapter
        }


    }
}