package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.model.ListItem

data class DetailedItemRV(
    val name: String,
    val image: Int,
    val description: String
) : ListItem {
    override val itemId: Long = name.hashCode().toLong()

}
