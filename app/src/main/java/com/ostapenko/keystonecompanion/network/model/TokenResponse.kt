package com.ostapenko.keystonecompanion.network.model

import com.google.gson.annotations.SerializedName

data class TokenResponse(@SerializedName("price") val tokenPrice:String)
