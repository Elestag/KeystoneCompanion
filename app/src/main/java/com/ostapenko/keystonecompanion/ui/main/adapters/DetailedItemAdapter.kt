package com.ostapenko.keystonecompanion.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.DetailedItemRV
import com.ostapenko.keystonecompanion.model.dungeons.DungeonsItemRV

class DetailedItemAdapter(private val items: List<DetailedItemRV>) :
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
        holder.name.text = item.name
        holder.image.setImageResource(item.image)
        holder.description.text = item.description
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.boss_name_1)
        val image: ImageView = view.findViewById(R.id.boss_icon_1)
        val description: TextView = view.findViewById(R.id.boss_description_1)
    }
}