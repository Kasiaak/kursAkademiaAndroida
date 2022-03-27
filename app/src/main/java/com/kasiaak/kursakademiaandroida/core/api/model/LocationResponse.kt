package com.kasiaak.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationRemote>
) {
    companion object
}