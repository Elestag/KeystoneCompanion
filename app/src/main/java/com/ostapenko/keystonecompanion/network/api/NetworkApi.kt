package com.ostapenko.keystonecompanion.network.api

import com.ostapenko.keystonecompanion.model.Region
import com.ostapenko.keystonecompanion.network.model.AffixesResponse
import com.ostapenko.keystonecompanion.network.model.CutoffsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkApi {

    @GET("v1/mythic-plus/affixes")
    suspend fun getWeeklyAffixes(
        @Query("region") region: String,
        @Query("locale") locale: String
    ): AffixesResponse

    @GET("v1/mythic-plus/season-cutoffs?season=season-df-3")
    suspend fun getSeasonCutoffs(@Query("region") region: String): Response<CutoffsResponse>
}