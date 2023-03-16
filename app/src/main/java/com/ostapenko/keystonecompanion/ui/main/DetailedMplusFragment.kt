package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonDetailedRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.AddonDungeon
import com.ostapenko.keystonecompanion.model.dungeons.SeasonDungeon
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBossImpl
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.ui.main.adapters.DetailedItemAdapter
import com.ostapenko.keystonecompanion.ui.main.adapters.MplusItemAdapter

class DetailedMplusFragment : Fragment(R.layout.item_dungeon_detailed_rv) {

    private val binding by viewBinding { ItemDungeonDetailedRvBinding.bind(it) }
    private lateinit var myAdapter: DetailedItemAdapter

    //TODO сделать енам для описания данжей с картинками и роутами
    //TODO сделать возможность сворачивать описание босса и типсов

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
        }

    }

    private fun showDetailedDungeon(name: String): List<DungeonBossImpl> {
        var dungeonBosses = listOf<DungeonBossImpl>()
        when (name) {
            "The Azure Vault" -> dungeonBosses = listOf(
                SeasonDungeon.TheAzureVault.boss1,
                SeasonDungeon.TheAzureVault.boss2,
                SeasonDungeon.TheAzureVault.boss3,
                SeasonDungeon.TheAzureVault.boss4
            )
            "Algeth\'ar Academy" -> dungeonBosses = listOf(
                SeasonDungeon.AlgetharAcademy.boss1,
                SeasonDungeon.AlgetharAcademy.boss2,
                SeasonDungeon.AlgetharAcademy.boss3,
                SeasonDungeon.AlgetharAcademy.boss4
            )
            "Ruby Life Pools" -> dungeonBosses = listOf(
                SeasonDungeon.RubyLifePools.boss1,
                SeasonDungeon.RubyLifePools.boss2,
                SeasonDungeon.RubyLifePools.boss3,
            )
            "The Nokhud Offensive" -> dungeonBosses = listOf(
                SeasonDungeon.TheNokhudOffensive.boss1,
                SeasonDungeon.TheNokhudOffensive.boss2,
                SeasonDungeon.TheNokhudOffensive.boss3,
                SeasonDungeon.TheNokhudOffensive.boss4
            )
            "Court of Stars" -> dungeonBosses = listOf(
                SeasonDungeon.CourtOfStars.boss1,
                SeasonDungeon.CourtOfStars.boss2,
                SeasonDungeon.CourtOfStars.boss3,
            )
            "Halls of Valor" -> dungeonBosses = listOf(
                SeasonDungeon.HallsOfValor.boss1,
                SeasonDungeon.HallsOfValor.boss2,
                SeasonDungeon.HallsOfValor.boss3,
                SeasonDungeon.HallsOfValor.boss4,
                SeasonDungeon.HallsOfValor.boss5
            )
            "Temple of the Jade Serpent" -> dungeonBosses = listOf(
                SeasonDungeon.TempleOfJadeSerpent.boss1,
                SeasonDungeon.TempleOfJadeSerpent.boss2,
                SeasonDungeon.TempleOfJadeSerpent.boss3,
                SeasonDungeon.TempleOfJadeSerpent.boss4
            )
            "Shadowmoon Burial Grounds" -> dungeonBosses = listOf(
                SeasonDungeon.ShadowmoonBurialGrounds.boss1,
                SeasonDungeon.ShadowmoonBurialGrounds.boss2,
                SeasonDungeon.ShadowmoonBurialGrounds.boss3,
                SeasonDungeon.ShadowmoonBurialGrounds.boss4
            )
        }
        return dungeonBosses
    }

}