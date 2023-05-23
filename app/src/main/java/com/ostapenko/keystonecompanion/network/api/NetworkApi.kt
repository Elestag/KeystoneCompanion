package com.ostapenko.keystonecompanion.network.api

import com.ostapenko.keystonecompanion.network.model.AffixesResponse
import com.ostapenko.keystonecompanion.network.model.CutoffsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {

    @GET("v1/mythic-plus/affixes?region=eu&locale=en")
    suspend fun getWeeklyAffixes(): AffixesResponse

    @GET("v1/mythic-plus/season-cutoffs?season=season-df-2&region=eu")
    suspend fun getSeasonCutoffs(): Response<CutoffsResponse>
}