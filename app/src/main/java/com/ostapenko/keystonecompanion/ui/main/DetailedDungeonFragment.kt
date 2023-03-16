package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonDetailedRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.AddonDungeon
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBossImpl
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.ui.main.adapters.DetailedItemAdapter

class DetailedDungeonFragment : Fragment(R.layout.item_dungeon_detailed_rv) {

    private val binding by viewBinding { ItemDungeonDetailedRvBinding.bind(it) }
    private lateinit var myAdapter: DetailedItemAdapter
    private val mySnapHelper = PagerSnapHelper()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val name = args?.getString("name")

        if (name !== null) {

            binding.dungeonTextViewName.text = name
            myAdapter = DetailedItemAdapter(showDetailedDungeon(name))
            binding.detailedDungeonRecyclerView.apply {
                adapter = myAdapter

            }
            mySnapHelper.attachToRecyclerView(binding.detailedDungeonRecyclerView)
        }

    }

    private fun showDetailedDungeon(name: String): List<DungeonBossImpl> {
        var dungeonBosses = listOf<DungeonBossImpl>()
        when (name) {
            "The Azure Vault" -> dungeonBosses = listOf(
                AddonDungeon.TheAzureVault.boss1,
                AddonDungeon.TheAzureVault.boss2,
                AddonDungeon.TheAzureVault.boss3,
                AddonDungeon.TheAzureVault.boss4
            )
            "Algeth\'ar Academy" -> dungeonBosses = listOf(
                AddonDungeon.AlgetharAcademy.boss1,
                AddonDungeon.AlgetharAcademy.boss2,
                AddonDungeon.AlgetharAcademy.boss3,
                AddonDungeon.AlgetharAcademy.boss4
            )
            "Ruby Life Pools" -> dungeonBosses = listOf(
                AddonDungeon.RubyLifePools.boss1,
                AddonDungeon.RubyLifePools.boss2,
                AddonDungeon.RubyLifePools.boss3,
            )
            "The Nokhud Offensive" -> dungeonBosses = listOf(
                AddonDungeon.TheNokhudOffensive.boss1,
                AddonDungeon.TheNokhudOffensive.boss2,
                AddonDungeon.TheNokhudOffensive.boss3,
                AddonDungeon.TheNokhudOffensive.boss4
            )
            "Brackenhide Hollow" -> dungeonBosses = listOf(
                AddonDungeon.BrackenhideHollow.boss1,
                AddonDungeon.BrackenhideHollow.boss2,
                AddonDungeon.BrackenhideHollow.boss3,
                AddonDungeon.BrackenhideHollow.boss4
            )
            "Uldaman: Legacy of Tyr" -> dungeonBosses = listOf(
                AddonDungeon.UldamanLegacyOfTyr.boss1,
                AddonDungeon.UldamanLegacyOfTyr.boss2,
                AddonDungeon.UldamanLegacyOfTyr.boss3,
                AddonDungeon.UldamanLegacyOfTyr.boss4,
                AddonDungeon.UldamanLegacyOfTyr.boss5
            )
            "Neltharus" -> dungeonBosses = listOf(
                AddonDungeon.Neltharus.boss1,
                AddonDungeon.Neltharus.boss2,
                AddonDungeon.Neltharus.boss3,
                AddonDungeon.Neltharus.boss4
            )
            "Halls of Infusion" -> dungeonBosses = listOf(
                AddonDungeon.HallsOfInfusion.boss1,
                AddonDungeon.HallsOfInfusion.boss2,
                AddonDungeon.HallsOfInfusion.boss3,
                AddonDungeon.HallsOfInfusion.boss4
            )
        }
        return dungeonBosses
    }
}