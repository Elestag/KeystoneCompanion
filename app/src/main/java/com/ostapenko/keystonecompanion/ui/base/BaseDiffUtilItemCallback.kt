package com.ostapenko.keystonecompanion.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.ostapenko.keystonecompanion.model.ListItem

open class BaseDiffUtilItemCallback:DiffUtil.ItemCallback<ListItem>(){
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
       return oldItem.equals(newItem)
    }

}