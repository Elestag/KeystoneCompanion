package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.model.ListItem

data class DungeonsItemRV(
    val name: String,
    val image: Int
) : ListItem {
    override val itemId: Long = name.hashCode().toLong()

}
