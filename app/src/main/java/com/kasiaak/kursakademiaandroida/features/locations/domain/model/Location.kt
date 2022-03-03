package com.kasiaak.kursakademiaandroida.features.locations.domain.model

class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
) {
}