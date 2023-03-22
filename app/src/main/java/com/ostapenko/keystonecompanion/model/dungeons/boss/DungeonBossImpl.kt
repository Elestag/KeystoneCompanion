package com.ostapenko.keystonecompanion.model.dungeons.boss

data class DungeonBossImpl(
    val nameResId: Int,
    val imageResId: Int,
    val descriptionResId: Int,
    val bossTips: String = ""
) : DungeonBoss
