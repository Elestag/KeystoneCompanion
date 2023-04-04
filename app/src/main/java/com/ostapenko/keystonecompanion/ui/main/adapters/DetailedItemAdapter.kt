package com.ostapenko.keystonecompanion.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBoss
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBossImpl
import com.skydoves.expandablelayout.ExpandableLayout

class DetailedItemAdapter(private val items: List<DungeonBossImpl>) :
    RecyclerView.Adapter<DetailedItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailedItemAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dungeon_detailed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailedItemAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.name.setText(item.nameResId)
        holder.image.setImageResource(item.imageResId)
        holder.description.setText(item.descriptionResId)
        holder.bossTips.setText(R.string.tips_melidrussa_chillworn)

        holder.expandableDescr.setOnExpandListener {
            holder.description.maxLines = Int.MAX_VALUE
        }

        holder.expandableTips.setOnExpandListener {
            holder.bossTips.maxLines = Int.MAX_VALUE
        }

        holder.expandableDescr.setOnClickListener {
            if (holder.expandableDescr.isExpanded) {
                holder.expandableDescr.collapse()
            } else {
                holder.expandableDescr.expand()
            }
        }

        holder.expandableTips.setOnClickListener {
            if (holder.expandableTips.isExpanded) {
                holder.expandableTips.collapse()
            } else {
                holder.expandableTips.expand()
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.boss_name_1)
        val image: ImageView = view.findViewById(R.id.boss_icon_1)
        val description: TextView = view.findViewById(R.id.boss_description_1)
        val bossTips: TextView = view.findViewById(R.id.boss_tips_1)
        val expandableDescr: ExpandableLayout = view.findViewById(R.id.expandable_description)
        val expandableTips: ExpandableLayout = view.findViewById(R.id.expandable_tips)

    }
}