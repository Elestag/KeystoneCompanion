package com.ostapenko.keystonecompanion.network.api

import com.ostapenko.keystonecompanion.network.model.AffixesResponse
import retrofit2.http.GET

interface RaiderIoApi {

    @GET("v1/mythic-plus/affixes?region=eu&locale=en")
    suspend fun getWeeklyAffixes(): AffixesResponse
}