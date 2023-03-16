package com.ostapenko.keystonecompanion.ui.main.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ostapenko.keystonecompanion.R

import com.ostapenko.keystonecompanion.model.dungeons.SeasonDungeon

import com.ostapenko.keystonecompanion.ui.main.DetailedMplusFragment

class MplusItemAdapter(private val items: List<SeasonDungeon>) :
    RecyclerView.Adapter<MplusItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MplusItemAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dungeon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MplusItemAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.image.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.dungeon_text_view_name)
        val image: ImageView = view.findViewById(R.id.dungeon_image_view)

        init {
            view.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("name", name.text.toString())

                val fragment = DetailedMplusFragment()
                fragment.arguments = bundle

                val transaction = view.context as AppCompatActivity
                transaction.supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}