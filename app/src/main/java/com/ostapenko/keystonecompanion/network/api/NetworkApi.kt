package com.ostapenko.keystonecompanion.network.api

import com.ostapenko.keystonecompanion.network.model.AffixesResponse
import com.ostapenko.keystonecompanion.network.model.TokenResponse
import retrofit2.http.GET

interface NetworkApi {

    @GET("v1/mythic-plus/affixes?region=eu&locale=en")
    suspend fun getWeeklyAffixes(): AffixesResponse

    @GET("data/wow/token/index?namespace=dynamic-eu&locale=en_US&access_token=EUjagpBK7K6dt9DjS5tKMh63crgeHeP401")
    suspend fun getTokenPrice(): TokenResponse
}