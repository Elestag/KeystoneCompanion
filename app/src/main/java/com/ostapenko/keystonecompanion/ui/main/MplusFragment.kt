package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonsRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.DungeonsItemRV
import com.ostapenko.keystonecompanion.model.dungeons.SeasonDungeon
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.ui.main.adapters.DungeonsItemAdapter
import com.ostapenko.keystonecompanion.ui.main.adapters.MplusItemAdapter

class MplusFragment : Fragment(R.layout.item_dungeons_rv) {

    private val seasonDungeonList: List<SeasonDungeon> = listOf(
        SeasonDungeon.BrackenhideHollow,
        SeasonDungeon.Freehold,
        SeasonDungeon.HallsOfInfusion,
        SeasonDungeon.NeltarionsLair,
        SeasonDungeon.Neltharus,
        SeasonDungeon.TheUnderrot,
        SeasonDungeon.TheVortexPinnacle,
        SeasonDungeon.UldamanLegacyOfTyr
    )

    private val binding by viewBinding { ItemDungeonsRvBinding.bind(it) }
    private val myAdapter = MplusItemAdapter(seasonDungeonList)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dungeonsRecyclerView.apply {
            adapter = myAdapter
        }
    }
}