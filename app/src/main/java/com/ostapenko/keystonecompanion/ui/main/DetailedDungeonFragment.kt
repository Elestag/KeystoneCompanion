package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonDetailedRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.DetailedItemRV
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.ui.main.adapters.DetailedItemAdapter

class DetailedDungeonFragment : Fragment(R.layout.item_dungeon_detailed_rv) {

    private val binding by viewBinding { ItemDungeonDetailedRvBinding.bind(it) }
    private lateinit var myAdapter: DetailedItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val name = args?.getString("name")

        if (name !== null) {
            val dungeons = listOf(
                DetailedItemRV(name, R.drawable.creature_leymor, "Some text or route will be here"),
                DetailedItemRV(
                    name,
                    R.drawable.the_azure_vault_small,
                    "Some text or route will be here"
                )
            )

            myAdapter = DetailedItemAdapter(dungeons)
            binding.detailedDungeonRecyclerView.apply {
                adapter = myAdapter
            }
        }

    }
}