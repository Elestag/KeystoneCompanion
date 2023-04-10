package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import android.widget.ImageView
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
    //TODO найти известные типсы по текущим и будущим данжам и решить вводить ли такую категорию

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val name = args?.getString("name")

        if (name !== null) {

            binding.dungeonTextViewName.text = name
            binding.descriptionTextView.text = dungeonDescription(name)
            setDungeonImage(binding.dungeonImageView, name)
            myAdapter = DetailedItemAdapter(showDetailedDungeon(name))
            binding.detailedDungeonRecyclerView.apply {
                adapter = myAdapter
            }
        }

    }

    private fun showDetailedDungeon(name: String): List<DungeonBossImpl> {
        var dungeonBosses = listOf<DungeonBossImpl>()
        when (name) {
            "Brackenhide Hollow" -> dungeonBosses = listOf(
                SeasonDungeon.BrackenhideHollow.boss1,
                SeasonDungeon.BrackenhideHollow.boss2,
                SeasonDungeon.BrackenhideHollow.boss3,
                SeasonDungeon.BrackenhideHollow.boss4
            )
            "Uldaman: Legacy of Tyr" -> dungeonBosses = listOf(
                SeasonDungeon.UldamanLegacyOfTyr.boss1,
                SeasonDungeon.UldamanLegacyOfTyr.boss2,
                SeasonDungeon.UldamanLegacyOfTyr.boss3,
                SeasonDungeon.UldamanLegacyOfTyr.boss4,
                SeasonDungeon.UldamanLegacyOfTyr.boss5

            )
            "Neltharus" -> dungeonBosses = listOf(
                SeasonDungeon.Neltharus.boss1,
                SeasonDungeon.Neltharus.boss2,
                SeasonDungeon.Neltharus.boss3,
                SeasonDungeon.Neltharus.boss4
            )
            "Halls of Infusion" -> dungeonBosses = listOf(
                SeasonDungeon.HallsOfInfusion.boss1,
                SeasonDungeon.HallsOfInfusion.boss2,
                SeasonDungeon.HallsOfInfusion.boss3,
                SeasonDungeon.HallsOfInfusion.boss4
            )
            "Neltharion\'s" -> dungeonBosses = listOf(
                SeasonDungeon.NeltarionsLair.boss1,
                SeasonDungeon.NeltarionsLair.boss2,
                SeasonDungeon.NeltarionsLair.boss3,
                SeasonDungeon.NeltarionsLair.boss4
            )
            "The Underrot" -> dungeonBosses = listOf(
                SeasonDungeon.TheUnderrot.boss1,
                SeasonDungeon.TheUnderrot.boss2,
                SeasonDungeon.TheUnderrot.boss3,
                SeasonDungeon.TheUnderrot.boss4
            )
            "Freehold" -> dungeonBosses = listOf(
                SeasonDungeon.Freehold.boss1,
                SeasonDungeon.Freehold.boss2,
                SeasonDungeon.Freehold.boss3,
                SeasonDungeon.Freehold.boss4
            )
            "The Vortex Pinnacle" -> dungeonBosses = listOf(
                SeasonDungeon.TheVortexPinnacle.boss1,
                SeasonDungeon.TheVortexPinnacle.boss2,
                SeasonDungeon.TheVortexPinnacle.boss3
            )
        }
        return dungeonBosses
    }

    private fun dungeonDescription(name: String): String {
        var description = ""
        when (name) {
            "Neltharion\'s" -> description = getString(R.string.description_neltharions_lair)
            "The Underrot" -> description = getString(R.string.description_the_underrot)
            "Freehold" -> description = getString(R.string.description_freehold)
            "The Vortex Pinnacle" -> description =
                getString(R.string.description_the_vortex_pinnacle)
            "Brackenhide Hollow" -> description = getString(R.string.description_brackenhide_hollow)
            "Uldaman: Legacy of Tyr" -> description =
                getString(R.string.description_uldaman_legacy_of_tyr)
            "Neltharus" -> description = getString(R.string.description_neltharus)
            "Halls of Infusion" -> description = getString(R.string.description_halls_of_infusion)
        }
        return description
    }

    private fun setDungeonImage(view: ImageView, name: String) {
        when (name) {
            "Neltharion\'s" -> view.setImageResource(R.drawable.neltharions_lair_small)
            "The Underrot" -> view.setImageResource(R.drawable.the_underrot_small)
            "Freehold" -> view.setImageResource(R.drawable.freehold_small)
            "The Vortex Pinnacle" -> view.setImageResource(R.drawable.the_vortex_pinnacle_small)
            "Brackenhide Hollow" -> view.setImageResource(R.drawable.algethar_academy_small)
            "Uldaman: Legacy of Tyr" -> view.setImageResource(R.drawable.algethar_academy_small)
            "Neltharus" -> view.setImageResource(R.drawable.algethar_academy_small)
            "Halls of Infusion" -> view.setImageResource(R.drawable.algethar_academy_small)
        }
    }

}