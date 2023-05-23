package com.ostapenko.keystonecompanion.network.model

import com.google.gson.annotations.SerializedName

data class AffixesResponse(@SerializedName("title") val title:String)

data class CutoffsResponse(@SerializedName("cutoffs") val pnine: Pnine)
data class Pnine(@SerializedName("p999") val cutoffs: Cutoffs)
data class Cutoffs(val all: AllData, val allColor: String)
data class AllData(
    val quantile: Double,
    val quantileMinValue: Double,
    val quantilePopulationCount: Int,
    val quantilePopulationFraction: Double,
    val totalPopulationCount: Int
)
