package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonsRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.AddonDungeon
import com.ostapenko.keystonecompanion.model.dungeons.DungeonsItemRV
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.ui.main.adapters.DungeonsItemAdapter

class DungeonsFragment : Fragment(R.layout.item_dungeons_rv) {


   private val dungeonList: List<AddonDungeon> = listOf(
        AddonDungeon.AlgetharAcademy,
        AddonDungeon.BrackenhideHollow,
        AddonDungeon.HallsOfInfusion,
        AddonDungeon.Neltharus,
        AddonDungeon.TheNokhudOffensive,
        AddonDungeon.RubyLifePools,
        AddonDungeon.TheAzureVault,
        AddonDungeon.UldamanLegacyOfTyr
    )

    private val binding by viewBinding { ItemDungeonsRvBinding.bind(it) }
    private val myAdapter = DungeonsItemAdapter(dungeonList)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dungeonsRecyclerView.apply {
            adapter = myAdapter
        }


    }
}