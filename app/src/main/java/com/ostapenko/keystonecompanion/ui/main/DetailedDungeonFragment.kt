package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonDetailedRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.AddonDungeon
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
            val dungeonBosses = listOf(
                AddonDungeon.TheAzureVault.boss1,
                AddonDungeon.TheAzureVault.boss2,
                AddonDungeon.TheAzureVault.boss3,
                AddonDungeon.TheAzureVault.boss4
            )

            binding.dungeonTextViewName.text = name
            myAdapter = DetailedItemAdapter(dungeonBosses)
            binding.detailedDungeonRecyclerView.apply {
                adapter = myAdapter

            }
            mySnapHelper.attachToRecyclerView(binding.detailedDungeonRecyclerView)
        }

    }
}