package com.ostapenko.keystonecompanion.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.DungeonsItemRV

class DungeonsItemAdapter(private val items: List<DungeonsItemRV>) :
    RecyclerView.Adapter<DungeonsItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DungeonsItemAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dungeon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DungeonsItemAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.image.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.dungeon_text_view_name)
        val image: ImageView = view.findViewById(R.id.dungeon_image_view)
    }
}