package com.kasiaak.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}