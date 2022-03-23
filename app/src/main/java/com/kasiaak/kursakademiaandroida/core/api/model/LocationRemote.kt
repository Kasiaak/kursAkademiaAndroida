package com.kasiaak.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName


data class LocationRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("dimension") val dimension: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)