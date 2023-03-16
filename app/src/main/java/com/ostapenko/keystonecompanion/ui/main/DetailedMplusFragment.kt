package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonDetailedRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.AddonDungeon
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.ui.main.adapters.DetailedItemAdapter
import com.ostapenko.keystonecompanion.ui.main.adapters.MplusItemAdapter

class DetailedMplusFragment : Fragment(R.layout.item_dungeon_detailed_rv) {

    private val binding by viewBinding { ItemDungeonDetailedRvBinding.bind(it) }
    private lateinit var myAdapter: DetailedItemAdapter

    //TODO сделать енам для описания данжкй с картинками и роутами
    //TODO сделать енам для описания боссов с картинками
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val name = args?.getString("name")

        if (name !== null) {
            val dungeonBosses = listOf(
                AddonDungeon.TheAzureVault.boss1,
                AddonDungeon.TheAzureVault.boss2,
                AddonDungeon.TheAzureVault.boss3,
                AddonDungeon.TheAzureVault.boss4
            )

            myAdapter = DetailedItemAdapter(dungeonBosses)
            binding.detailedDungeonRecyclerView.apply {
                adapter = myAdapter
            }
        }

    }
}